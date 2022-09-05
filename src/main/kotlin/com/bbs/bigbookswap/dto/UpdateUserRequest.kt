// Written By: Lisa Daly (StudentID: 10570708) - DBS 2022 Final Project B8IT131_2122_TME2 //
// Definition of Data Class : UpdateUserRequest - format of update (put) requests made to User API

package com.bbs.bigbookswap.dto
data class UpdateUserRequest (
    val id: Long,
    var avatar: String? = null,
    var numBooks: Long? = null,
    var numSwaps: Long? = null,
    var numDonations: Long? = null)