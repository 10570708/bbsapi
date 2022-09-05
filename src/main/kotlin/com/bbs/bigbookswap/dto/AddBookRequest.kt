// Written By: Lisa Daly (StudentID: 10570708) - DBS 2022 Final Project B8IT131_2122_TME2 //
// Definition of Data Class : AddBookRequest - format of requests to Book API

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