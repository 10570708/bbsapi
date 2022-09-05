// Written By: Lisa Daly (StudentID: 10570708) - DBS 2022 Final Project B8IT131_2122_TME2 //
// Definition of Data Class : ErrorResponse - format of response objs from all APIs

package com.bbs.bigbookswap.dto

import java.time.LocalDateTime
data class ErrorResponse(
    val title: String = "Bad Request",
    val message: String,
    val dateTime: LocalDateTime = LocalDateTime.now()
)