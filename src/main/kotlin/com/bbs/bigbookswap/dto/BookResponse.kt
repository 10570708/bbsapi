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