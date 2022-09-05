// Written By: Lisa Daly (StudentID: 10570708) - DBS 2022 Final Project B8IT131_2122_TME2 //
// Definition of Data Class : UpdateBookRequest - format of update (put) requests made to Book API

package com.bbs.bigbookswap.dto

import com.fasterxml.jackson.annotation.JsonFormat
@JsonFormat(with = [JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY])
data class UpdateBookRequest(
    var id: Long,
    var status: String,
)