package com.bbs.bigbookswap.dto

import java.util.*

data class UserResponse (val id:Long = 1,
                         var lastLogin: Date,
                         var avatar: String,
                         var numBooks: Long,
                         var numSwaps: Long,
                         var numDonations: Long)