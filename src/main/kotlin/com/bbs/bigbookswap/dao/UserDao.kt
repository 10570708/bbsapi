// Written By: Lisa Daly (StudentID: 10570708) - DBS 2022 Final Project B8IT131_2122_TME2 //
// Contains the custom JPA Repository queries for Users - particularly by search criteria :
// Avatar | Username

package com.bbs.bigbookswap.dao

import com.bbs.bigbookswap.domain.BBSUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserDao : JpaRepository<BBSUser, Long> {

    fun findByAvatar(avatar: String): List<BBSUser>
    fun findByUsername(username: String): BBSUser?

}