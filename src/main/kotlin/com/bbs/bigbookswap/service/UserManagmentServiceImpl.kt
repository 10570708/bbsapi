// Written By: Lisa Daly (StudentID: 10570708) - DBS 2022 Final Project B8IT131_2122_TME2 //
// Implementation of the UserManagement Service and the override methods for the interface

package com.bbs.bigbookswap.service

import com.bbs.bigbookswap.dao.UserDao
import com.bbs.bigbookswap.domain.BBSUser
import com.bbs.bigbookswap.dto.AddUserRequest
import com.bbs.bigbookswap.dto.UpdateUserRequest
import com.bbs.bigbookswap.dto.UserResponse
import com.bbs.bigbookswap.transformer.AddUserRequestTransformer
import com.bbs.bigbookswap.transformer.toUserResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserManagementServiceImpl(
    private val userDao: UserDao,
    private val addUserRequestTransformer: AddUserRequestTransformer
) : UserManagmentService {

    override fun findByUsername(username: String): BBSUser? = this.userDao.findByUsername(username)

    override fun findById(id: Long): BBSUser? = this.findUserById(id)

    override fun findByAvatar(avatar: String): List<UserResponse> =
        this.userDao.findByAvatar(avatar).map(BBSUser::toUserResponse)

    override fun findAll(pageable: Pageable): Page<UserResponse> =
        this.userDao.findAll(pageable).map(BBSUser::toUserResponse)

    override fun save(addUserRequest: AddUserRequest): UserResponse {
        return this.saveOrUpdate(
            addUserRequestTransformer.transform(addUserRequest)
        )
    }

    override fun update(updateUserRequest: UpdateUserRequest): UserResponse {
        val user =
            this.findUserById(updateUserRequest.id) ?: throw IllegalStateException("${updateUserRequest.id} not found")
        return this.saveOrUpdate(user.apply {
            this.numBooks = updateUserRequest.numBooks ?: this.numBooks
            this.numSwaps = updateUserRequest.numSwaps ?: this.numSwaps
            this.numDonations = updateUserRequest.numDonations ?: this.numDonations
            this.avatar = updateUserRequest.avatar ?: this.avatar
        })

    }

    override fun updateBookCount(id: Long): UserResponse {
        val user = this.findUserById(id) ?: throw IllegalStateException("$id not found I'm afraid ! ")

        return this.saveOrUpdate(user.apply {
            this.numBooks++
        })
    }


    override fun reduceBookCount(id: Long): UserResponse {
        val user = this.findUserById(id) ?: throw IllegalStateException("$id not found I'm afraid ! ")

        return this.saveOrUpdate(user.apply {
            this.numBooks--
        })
    }

    override fun updateSwapCount(id: Long): UserResponse {
        val user = this.findUserById(id) ?: throw IllegalStateException("$id not found I'm afraid ! ")

        return this.saveOrUpdate(user.apply {
            this.numSwaps++
        })
    }

    override fun updateDonateCount(id: Long): UserResponse {
        val user = this.findUserById(id) ?: throw IllegalStateException("$id not found I'm afraid ! ")

        return this.saveOrUpdate(user.apply {
            this.numDonations++
        })
    }

    override fun updateAvatar(id: Long, avatar: String): UserResponse {
        val user = this.findUserById(id) ?: throw IllegalStateException("$id not found I'm afraid ! ")

        return this.saveOrUpdate(user.apply {
            this.avatar = avatar
        })
    }

    override fun delete(id: Long) {
        this.userDao.deleteById(id)
    }

    private fun findUserById(id: Long): BBSUser? = this.userDao.findByIdOrNull(id)

    private fun saveOrUpdate(user: BBSUser): UserResponse = this.userDao.save(user).toUserResponse()
}