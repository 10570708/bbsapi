package com.bbs.bigbookswap.resource

import com.bbs.bigbookswap.dto.AddUserRequest
import com.bbs.bigbookswap.dto.UpdateUserRequest
import com.bbs.bigbookswap.dto.UserResponse
import com.bbs.bigbookswap.resource.UserResourceImpl.Companion.BASE_USER_URL
import com.bbs.bigbookswap.service.UserManagmentService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping(value= [BASE_USER_URL])
class UserResourceImpl(private val userManagmentService: UserManagmentService) : UserResource {

    @GetMapping("/{id}")
    override fun findById(@PathVariable id: Long): ResponseEntity<UserResponse> {
        val userResponse = this.userManagmentService.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(userResponse)
    }

    @GetMapping("/all")
    override fun findAll(pageable: Pageable): ResponseEntity<Page<UserResponse>>
    {
        return ResponseEntity.ok(this.userManagmentService.findAll(pageable))
    }

    @PostMapping
    override fun save(@RequestBody addUserRequest: AddUserRequest): ResponseEntity<UserResponse> {
        val userResponse = this.userManagmentService.save( addUserRequest )
        return ResponseEntity
            .created(URI.create(BASE_USER_URL.plus("/${userResponse.id}")))
            .body(userResponse)
    }


    @PutMapping("/{id}")
    override fun update(@RequestBody updateUserRequest: UpdateUserRequest): ResponseEntity<UserResponse> {
        return ResponseEntity.ok(this.userManagmentService.update(updateUserRequest))
    }

    @PutMapping("/bookcount/{id}")
    override fun updateBookCount(@PathVariable id:Long): ResponseEntity<UserResponse> {
        return ResponseEntity.ok(this.userManagmentService.updateBookCount(id))
    }

    @PutMapping("/swapcount/{id}")
    override fun updateSwapCount(@PathVariable id:Long): ResponseEntity<UserResponse> {
        return ResponseEntity.ok(this.userManagmentService.updateSwapCount(id))
    }


    @PutMapping("/donatecount/{id}")
    override fun updateDonateCount(@PathVariable id:Long): ResponseEntity<UserResponse> {
        return ResponseEntity.ok(this.userManagmentService.updateDonateCount(id))
    }

    @PutMapping("/avatar/{id}/{avatar}")
    override fun updateAvatar(@PathVariable id:Long, @PathVariable avatar: String): ResponseEntity<UserResponse> {
        return ResponseEntity.ok(this.userManagmentService.updateAvatar(id, avatar))
    }
    @DeleteMapping("/{id}")
    override fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        this.userManagmentService.delete(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/avatars/{avatar}")
    override fun findByAvatar(@PathVariable avatar: String): ResponseEntity<List<UserResponse>> {

        return ResponseEntity.ok(this.userManagmentService.findByAvatar(avatar))
    }

    companion object {
        const val BASE_USER_URL: String = "/api/v1/user"
    }
}