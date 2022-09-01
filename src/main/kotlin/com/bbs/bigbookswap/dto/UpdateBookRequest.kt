package com.bbs.bigbookswap.dto

import com.fasterxml.jackson.annotation.JsonFormat

@JsonFormat(with = [JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY])
data class UpdateBookRequest(
    var id: Long,
    var status: String,
)