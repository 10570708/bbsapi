package com.bbs.bigbookswap.dto

import java.util.*

data class SwapResponse (
    var id: Long,
    var offerMember: SwapMember,
    var recipientMember :SwapMember,
    var createdDate: Date,
    var swapDate: Date?,
    var status: String
)