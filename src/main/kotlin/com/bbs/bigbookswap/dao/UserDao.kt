package com.bbs.bigbookswap.dao

import com.bbs.bigbookswap.domain.BBSUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserDao: JpaRepository<BBSUser, Long> {

    fun findByAvatar(avatar: String): List<BBSUser>
}