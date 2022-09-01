package com.bbs.bigbookswap.transformer

import com.bbs.bigbookswap.domain.Book
import com.bbs.bigbookswap.dto.AddBookRequest
import org.springframework.stereotype.Component

@Component
class AddBookRequestTransformer : Transformer<AddBookRequest, Book> {

    override fun transform(source: AddBookRequest): Book {
        return Book(
            id = source.id,
            ownerId = source.ownerId,
            title = source.title,
            author = source.author,
            cover = source.cover,
            publisher = source.publisher,
            numPages = source.numPages,
            status = source.status,
            condition = source.condition,
            isbn = source.isbn,
            option = source.option
        )
    }
}