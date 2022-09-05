// Written By: Lisa Daly (StudentID: 10570708) - DBS 2022 Final Project B8IT131_2122_TME2 //

package com.bbs.bigbookswap.resource

import com.bbs.bigbookswap.domain.BBSUser
import com.bbs.bigbookswap.dto.Message
import com.bbs.bigbookswap.dto.UpdateUserRequest
import com.bbs.bigbookswap.dto.AddUserRequest
import com.bbs.bigbookswap.dto.UserResponse
import com.bbs.bigbookswap.dto.UserLoginRequest
import com.bbs.bigbookswap.resource.UserResourceImpl.Companion.BASE_USER_URL
import com.bbs.bigbookswap.service.UserManagementServiceImpl
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI
import java.util.Date
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletResponse

@CrossOrigin(origins = ["http://localhost:4200"])
@RestController
@RequestMapping(value = [BASE_USER_URL])
class UserResourceImpl(
    private val userManagementService: UserManagementServiceImpl
) : UserResource {

    @GetMapping("/{id}")
    override fun findById(@PathVariable id: Long): ResponseEntity<BBSUser> {
        val userResponse = this.userManagementService.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(userResponse)
    }

    @GetMapping("/all")
    override fun findAll(pageable: Pageable): ResponseEntity<Page<UserResponse>> {
        return ResponseEntity.ok(this.userManagementService.findAll(pageable))
    }

    @PostMapping
    override fun save(@RequestBody addUserRequest: AddUserRequest): ResponseEntity<UserResponse> {
        val userResponse = this.userManagementService.save(addUserRequest)
        return ResponseEntity
            .created(URI.create(BASE_USER_URL.plus("/${userResponse.id}")))
            .body(userResponse)
    }

    @CrossOrigin(origins = ["http://localhost:4200"])
    @PostMapping("login")
    override fun login(
        @RequestBody userLoginRequest: UserLoginRequest,
        response: HttpServletResponse
    ): ResponseEntity<Any> {

        val user = this.userManagementService.findByUsername(userLoginRequest.username)
            ?: return ResponseEntity.badRequest().body(Message("User not Found"))

        if (!user.comparePasswords(userLoginRequest.password, user.password))
            return ResponseEntity.badRequest().body(Message("Invalid password"))

        val issuer = user.id.toString()


        val jwt = Jwts.builder()
            .setIssuer(issuer)
            .setExpiration(Date(System.currentTimeMillis() + 86400000)) // 1 day
            .signWith(SignatureAlgorithm.HS512, "secret").compact()

        val cookie = Cookie("jwt", jwt)
        cookie.isHttpOnly = true

        response.addCookie(cookie)

        return ResponseEntity.ok(user)

    }

    @CrossOrigin(origins = ["http://localhost:4200"])
    @GetMapping("getme")
    fun user(@CookieValue("jwt") jwt: String?): ResponseEntity<Any> {
        try {
            if (jwt == null) {
                return ResponseEntity.status(401).body(Message("notauthenticated"))
            }

            val body = Jwts.parser().setSigningKey("secret").parseClaimsJws(jwt).body

            return ResponseEntity.ok(this.userManagementService.findById(body.issuer.toLong()))
        } catch (e: Exception) {
            return ResponseEntity.status(401).body(Message("notauthenticated"))
        }
    }

    @CrossOrigin(origins = ["http://localhost:4200"])
    @PostMapping("logout")
    fun logout(response: HttpServletResponse): ResponseEntity<Any> {

        val issuer = "none"
        val jwt = Jwts.builder()
            .setIssuer(issuer)
            .setExpiration(Date(System.currentTimeMillis() - 86400000)) // 1 day
            .signWith(SignatureAlgorithm.HS512, "secret").compact()

        val cookie = Cookie("jwt", jwt)
        cookie.maxAge = 0
        response.addCookie(cookie)
        return ResponseEntity.ok(Message("Cookie Removed"))
    }


    @PutMapping("/{id}")
    override fun update(@RequestBody updateUserRequest: UpdateUserRequest): ResponseEntity<UserResponse> {
        return ResponseEntity.ok(this.userManagementService.update(updateUserRequest))
    }

    @PutMapping("/bookcount/{id}")
    override fun updateBookCount(@PathVariable id: Long): ResponseEntity<UserResponse> {
        return ResponseEntity.ok(this.userManagementService.updateBookCount(id))
    }

    @PutMapping("/bookcount/reduce/{id}")
    override fun reduceBookCount(@PathVariable id: Long): ResponseEntity<UserResponse> {
        return ResponseEntity.ok(this.userManagementService.reduceBookCount(id))
    }

    @PutMapping("/swapcount/{id}")
    override fun updateSwapCount(@PathVariable id: Long): ResponseEntity<UserResponse> {
        return ResponseEntity.ok(this.userManagementService.updateSwapCount(id))
    }


    @PutMapping("/donatecount/{id}")
    override fun updateDonateCount(@PathVariable id: Long): ResponseEntity<UserResponse> {
        return ResponseEntity.ok(this.userManagementService.updateDonateCount(id))
    }

    @PutMapping("/avatar/{id}/{avatar}")
    override fun updateAvatar(@PathVariable id: Long, @PathVariable avatar: String): ResponseEntity<UserResponse> {
        return ResponseEntity.ok(this.userManagementService.updateAvatar(id, avatar))
    }

    @DeleteMapping("/{id}")
    override fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        this.userManagementService.delete(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/avatars/{avatar}")
    override fun findByAvatar(@PathVariable avatar: String): ResponseEntity<List<UserResponse>> {

        return ResponseEntity.ok(this.userManagementService.findByAvatar(avatar))
    }

    companion object {
        const val BASE_USER_URL: String = "/api/v1/user/"
    }
}