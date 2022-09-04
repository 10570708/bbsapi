package com.bbs.bigbookswap.service

import com.bbs.bigbookswap.dao.SwapDao
import com.bbs.bigbookswap.domain.Swap
import com.bbs.bigbookswap.dto.SwapResponse
import com.bbs.bigbookswap.dto.SwapRequest
import com.bbs.bigbookswap.transformer.SwapRequestTransformer
import com.bbs.bigbookswap.transformer.toSwapResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.Date

@Service
class SwapManagementServiceImpl(private val swapDao: SwapDao, private val addSwapRequestTransformer: SwapRequestTransformer): SwapManagementService
{


    override fun save(addSwapRequest: SwapRequest): SwapResponse {
        return this.saveOrUpdate(
            addSwapRequestTransformer.transform(addSwapRequest)).toSwapResponse()
    }

    override fun complete(updateSwapRequest: SwapRequest): SwapResponse {
        val swapRequest = addSwapRequestTransformer.transform(updateSwapRequest)

        val swap = this.findSwapbyId(swapRequest.id) ?: throw IllegalStateException("${updateSwapRequest.id} not found")

        return this.saveOrUpdate(swap.apply {
            this.offerOwnerId = swap.offerOwnerId
            this.type = swap.type
            this.offerAuthor = swap.offerAuthor
            this.offerTitle = swap.offerTitle
            this.offerCover = swap.offerCover
            this.offerBookId = swap.offerBookId
            this.createdDate = swap.createdDate
            this.recipientOwnerId = swap.recipientOwnerId
            this.recipientAuthor = swap.recipientAuthor
            this.recipientBookId = swap.recipientBookId
            this.recipientCover = swap.recipientCover
            this.recipientTitle = swap.recipientTitle
            this.status = swapRequest.status
            this.swapDate = Date()
        }).toSwapResponse()

        return this.saveOrUpdate(
            addSwapRequestTransformer.transform(updateSwapRequest)).toSwapResponse()
    }

    override fun update(updateSwapRequest: SwapRequest): SwapResponse {
        val swapRequest = addSwapRequestTransformer.transform(updateSwapRequest)


        val swap = this.findSwapbyId(swapRequest.id) ?: throw IllegalStateException("${updateSwapRequest.id} not found")


        return this.saveOrUpdate(swap.apply {
                this.offerOwnerId = swap.offerOwnerId
                this.type = swap.type
                this.offerAuthor = swap.offerAuthor
                this.offerTitle = swap.offerTitle
                this.offerCover = swap.offerCover
                this.offerBookId = swap.offerBookId
                this.createdDate = swap.createdDate
                this.recipientOwnerId = swapRequest.recipientOwnerId
                this.recipientAuthor = swapRequest.recipientAuthor
                this.recipientBookId = swapRequest.recipientBookId
                this.recipientCover = swapRequest.recipientCover
                this.recipientTitle = swapRequest.recipientTitle
                this.status = swapRequest.status
            }).toSwapResponse()
        }

    override fun findAllByOwnerId(id: Long): List<SwapResponse> = this.swapDao.findAllByRecipientOwnerIdOrOfferOwnerIdOrderByCreatedDateDesc(id,id).map(Swap::toSwapResponse)

    override fun findMyPendingById(id: Long): List<SwapResponse> = this.swapDao.findAllByOfferOwnerIdAndStatusIsIgnoreCaseOrRecipientOwnerIdAndStatusIsIgnoreCaseOrderByCreatedDateDesc(id, "Accepted", id, "Accepted").map(Swap::toSwapResponse)

    override fun findMyCompleteById(id: Long): List<SwapResponse> = this.swapDao.findAllByOfferOwnerIdAndStatusIsIgnoreCaseOrRecipientOwnerIdAndStatusIsIgnoreCaseOrderBySwapDateDesc(id, "Complete", id, "Complete").map(Swap::toSwapResponse)

    override fun findMyRequests(id: Long): List<SwapResponse> = this.swapDao.findByOfferOwnerIdAndStatusIgnoreCase(id,"Requested").map(Swap::toSwapResponse)

    override fun findMyOffers(id: Long): List<SwapResponse> = this.swapDao.findByRecipientOwnerIdAndStatusIgnoreCase(id,"Requested").map(Swap::toSwapResponse)

    private fun findSwapbyId(id: Long): Swap? = this.swapDao.findByIdOrNull(id)


private fun saveOrUpdate(swap: Swap): Swap = this.swapDao.save(swap)
}
