// Written By: Lisa Daly (StudentID: 10570708) - DBS 2022 Final Project B8IT131_2122_TME2 //
// Definition of the UserManagement Service Interface and all the Methods it defines

package com.bbs.bigbookswap.service

import com.bbs.bigbookswap.domain.BBSUser
import com.bbs.bigbookswap.dto.AddUserRequest
import com.bbs.bigbookswap.dto.UpdateUserRequest
import com.bbs.bigbookswap.dto.UserResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface UserManagmentService {
    fun findByUsername(username: String): BBSUser?
    fun findById(id: Long): BBSUser?
    fun findAll(pageable: Pageable): Page<UserResponse>
    fun save(addUserRequest: AddUserRequest): UserResponse
    fun update(updateUserRequest: UpdateUserRequest): UserResponse
    fun delete(id: Long)
    fun updateBookCount(id: Long): UserResponse
    fun reduceBookCount(id: Long): UserResponse
    fun updateSwapCount(id: Long): UserResponse
    fun updateDonateCount(id: Long): UserResponse
    fun updateAvatar(id: Long, avatar: String): UserResponse
    fun findByAvatar(avatar: String): List<UserResponse>
}