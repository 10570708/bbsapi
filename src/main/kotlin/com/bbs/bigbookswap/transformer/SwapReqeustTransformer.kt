package com.bbs.bigbookswap.transformer

import com.bbs.bigbookswap.domain.Swap
import com.bbs.bigbookswap.dto.SwapRequest
import org.springframework.stereotype.Component
import java.util.Date

@Component
class SwapRequestTransformer : Transformer<SwapRequest, Swap> {

    override fun transform(source: SwapRequest): Swap {
        return Swap(
            id = source.id,
            type = source.type,
            offerOwnerId = source.offerMember?.ownerId ?: 0,
            offerBookId = source.offerMember?.bookId ?: 0,
            offerTitle = source.offerMember?.bookTitle ?: "",
            offerAuthor = source.offerMember?.bookAuthor ?: "",
            offerCover = source.offerMember?.bookCover ?: "",
            recipientOwnerId = source.recipientMember?.ownerId ?: 0,
            recipientBookId = source.recipientMember?.bookId ?: 0,
            recipientTitle = source.recipientMember?.bookTitle ?: "",
            recipientAuthor = source.recipientMember?.bookAuthor ?: "",
            recipientCover = source.recipientMember?.bookCover ?: "",
            createdDate = source.createdDate ?: Date(),
            swapDate = source.swapDate ?: Date(),
            status = source.status
        )
    }
}