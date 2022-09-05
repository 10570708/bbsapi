// Written By: Lisa Daly (StudentID: 10570708) - DBS 2022 Final Project B8IT131_2122_TME2 //
// Definition of Data Class : SwapMember - used for both Recipient and Offer Members of a Swap object

package com.bbs.bigbookswap.dto
data class SwapMember(
    var ownerId: Long,
    var bookId: Long,
    var bookTitle: String,
    var bookAuthor: String,
    var bookCover: String,
)