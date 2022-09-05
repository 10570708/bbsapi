// Written By: Lisa Daly (StudentID: 10570708) - DBS 2022 Final Project B8IT131_2122_TME2 //
// Definition of Data Class : UserResponse - format of login response from User API

package com.bbs.bigbookswap.dto

import java.util.Date
data class UserResponse(
    val id: Long = 1,
    var lastLogin: Date,
    var avatar: String,
    var numBooks: Long,
    var numSwaps: Long,
    var numDonations: Long
)