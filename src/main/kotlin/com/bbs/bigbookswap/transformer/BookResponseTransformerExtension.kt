// Written By: Lisa Daly (StudentID: 10570708) - DBS 2022 Final Project B8IT131_2122_TME2 //
// Method to convert Book to BookResponse

package com.bbs.bigbookswap.transformer

import com.bbs.bigbookswap.domain.Book
import com.bbs.bigbookswap.dto.BookResponse
import java.util.Date

fun Book?.toBookResponse(): BookResponse {
    return BookResponse(
        id = this?.id ?: 0,
        ownerId = this?.ownerId ?: 0,
        title = this?.title ?: "",
        author = this?.author ?: "",
        cover = this?.cover ?: "",
        publisher = this?.publisher ?: "",
        numPages = this?.numPages ?: "",
        addedDate = this?.addedDate ?: Date(),
        status = this?.status ?: "",
        condition = this?.condition ?: "",
        isbn = this?.isbn ?: 0,
        option = this?.option ?: ""
    )
}