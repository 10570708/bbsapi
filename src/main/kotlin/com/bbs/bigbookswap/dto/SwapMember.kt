package com.bbs.bigbookswap.dto

data class SwapMember(
    var ownerId: Long,
    var bookId: Long,
    var bookTitle: String,
    var bookAuthor: String,
    var bookCover: String,
)