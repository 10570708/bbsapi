// Written By: Lisa Daly (StudentID: 10570708) - DBS 2022 Final Project B8IT131_2122_TME2 //
// Definition of Data Class : SwapResponse - format of responses from Swap API

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