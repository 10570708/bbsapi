// Written By: Lisa Daly (StudentID: 10570708) - DBS 2022 Final Project B8IT131_2122_TME2 //
// Definition of Data Class : SwapRequest - format of requests made to Swap API

package com.bbs.bigbookswap.dto

import com.fasterxml.jackson.annotation.JsonFormat
import java.util.Date
@JsonFormat(with = [JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY])
data class SwapRequest (
    var id: Long,
    var type: String,
    var offerMember: SwapMember?,
    var recipientMember:SwapMember?,
    var createdDate: Date?,
    var swapDate: Date?,
    var status: String
)
