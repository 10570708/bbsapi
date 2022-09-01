package com.bbs.bigbookswap.dto

import java.util.Date

data class SwapResponse (
    var id: Long,
    var type: String,
    var offerMember: SwapMember,
    var recipientMember :SwapMember,
    var createdDate: Date,
    var swapDate: Date?,
    var status: String
)