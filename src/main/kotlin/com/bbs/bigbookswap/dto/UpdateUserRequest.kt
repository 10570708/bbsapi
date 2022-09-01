package com.bbs.bigbookswap.dto

import java.util.Date

data class UpdateUserRequest (
    val id: Long,
    var avatar: String? = null,
    var numBooks: Long? = null,
    var numSwaps: Long? = null,
    var numDonations: Long? = null)