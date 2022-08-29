package com.bbs.bigbookswap.resource

import com.bbs.bigbookswap.domain.BBSUser
import com.bbs.bigbookswap.dto.AddUserRequest
import com.bbs.bigbookswap.dto.UpdateUserRequest
import com.bbs.bigbookswap.dto.UserLoginRequest
import com.bbs.bigbookswap.dto.UserResponse
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import javax.servlet.http.HttpServletResponse

interface UserResource {

    fun login(userLoginRequest: UserLoginRequest, response: HttpServletResponse): ResponseEntity<Any>
    fun findById(id: Long): ResponseEntity<BBSUser>
    fun findByAvatar(avatar: String): ResponseEntity<List<UserResponse>>
    fun findAll(pageable: org.springframework.data.domain.Pageable): ResponseEntity<Page<UserResponse>>
    fun save(addUserRequest: AddUserRequest): ResponseEntity<UserResponse>
    fun update(updateUserRequest: UpdateUserRequest): ResponseEntity<UserResponse>
    fun delete(id:Long): ResponseEntity<Unit>
    fun updateBookCount(id:Long): ResponseEntity<UserResponse>
    fun reduceBookCount(id:Long): ResponseEntity<UserResponse>
    fun updateSwapCount(id:Long): ResponseEntity<UserResponse>
    fun updateDonateCount(id:Long): ResponseEntity<UserResponse>
    fun updateAvatar(id:Long, avatar: String): ResponseEntity<UserResponse>
}