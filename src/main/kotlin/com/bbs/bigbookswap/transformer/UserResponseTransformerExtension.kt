package com.bbs.bigbookswap.transformer

import com.bbs.bigbookswap.domain.BBSUser
import com.bbs.bigbookswap.dto.UserResponse
import java.util.Date

fun BBSUser?.toUserResponse(): UserResponse{
    return UserResponse(
        id = this?.id ?: 0,
        lastLogin = this?.lastLogin ?: Date(),
        numBooks = this?.numBooks ?: 0,
        numSwaps = this?.numSwaps ?: 0,
        numDonations = this?.numDonations ?: 0,
        avatar = this?.avatar ?: ""
    )
}