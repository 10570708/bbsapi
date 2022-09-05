// Written By: Lisa Daly (StudentID: 10570708) - DBS 2022 Final Project B8IT131_2122_TME2 //
// Definition of Data Class : BookResponse - return from API calls to Book API

package com.bbs.bigbookswap.dto

import java.util.Date
data class BookResponse(
    val id: Long = 1,
    var ownerId: Long,
    var title: String,
    var author: String,
    var cover: String,
    var publisher: String,
    var numPages: String,
    var addedDate: Date,
    var status: String,
    var condition: String,
    var isbn: Long,
    var option: String
)