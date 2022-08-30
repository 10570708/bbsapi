package com.bbs.bigbookswap.service

import com.bbs.bigbookswap.dao.BookDao
import com.bbs.bigbookswap.dao.SwapDao
import com.bbs.bigbookswap.domain.BBSUser
import com.bbs.bigbookswap.domain.Book
import com.bbs.bigbookswap.domain.Swap
import com.bbs.bigbookswap.dto.*
import com.bbs.bigbookswap.transformer.*
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class SwapManagementServiceImpl(private val swapDao: SwapDao, private val addSwapRequestTransformer: SwapRequestTransformer): SwapManagementService
{


    override fun save(addSwapRequest: SwapRequest): SwapResponse {
        return this.saveOrUpdate(
            addSwapRequestTransformer.transform(addSwapRequest)).toSwapResponse()
    }

    override fun findAllByOwnerId(id: Long): List<SwapResponse> = this.swapDao.findAllByRecipientOwnerIdOrOfferOwnerId(id,id).map(Swap::toSwapResponse)  ?: emptyList()

    override fun findMyRequests(id: Long): List<SwapResponse> = this.swapDao.findByOfferOwnerId(id).map(Swap::toSwapResponse)  ?: emptyList()

    override fun findMyOffers(id: Long): List<SwapResponse> = this.swapDao.findByRecipientOwnerId(id).map(Swap::toSwapResponse)  ?: emptyList()



private fun saveOrUpdate(swap: Swap): Swap = this.swapDao.save(swap)
}
