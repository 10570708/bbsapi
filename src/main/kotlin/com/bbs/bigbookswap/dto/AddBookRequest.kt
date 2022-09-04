package com.bbs.bigbookswap.dto

import com.fasterxml.jackson.annotation.JsonFormat

@JsonFormat(with = [JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY])
data class AddBookRequest(
    var id: Long,
    var ownerId: Long,
    var title: String,
    var author: String,
    var cover: String,
    var publisher: String,
    var numPages: String,
    var status: String,
    var condition: String,
    var isbn: Long,
    var option: String
)