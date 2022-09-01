package com.bbs.bigbookswap.transformer

import com.bbs.bigbookswap.domain.Swap
import com.bbs.bigbookswap.dto.SwapMember
import com.bbs.bigbookswap.dto.SwapResponse
import java.util.Date

fun Swap?.toSwapResponse(): SwapResponse {
    return SwapResponse(
        id = this?.id ?: 0,
        type = this?.type ?: "",
        offerMember =
        SwapMember(
            this?.offerOwnerId ?: 0,
            this?.offerBookId ?: 0,
            this?.offerTitle ?: "",
            this?.offerAuthor ?: "",
            this?.offerCover ?: "",
        ),
        recipientMember =
        SwapMember(
            this?.recipientOwnerId ?: 0,
            this?.recipientBookId ?: 0,
            this?.recipientTitle ?: "",
            this?.recipientAuthor ?: "",
            this?.recipientCover ?: "",
        ),
        createdDate = this?.createdDate ?: Date(),
        swapDate = Date(),
        status = this?.status ?: ""
    )
}
