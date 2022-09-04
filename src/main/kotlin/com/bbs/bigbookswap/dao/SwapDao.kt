package com.bbs.bigbookswap.dao

import com.bbs.bigbookswap.domain.Swap
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SwapDao : JpaRepository<Swap, Long> {

    fun findAllByRecipientOwnerIdOrOfferOwnerIdOrderByCreatedDateDesc(RecipientOwnerId: Long, OfferOwnerId: Long): List<Swap>
    fun findByRecipientOwnerIdAndStatusIgnoreCase(id: Long, status: String): List<Swap>
    fun findByOfferOwnerIdAndStatusIgnoreCase(id: Long, status: String): List<Swap>
    fun findAllByOfferOwnerIdAndStatusIsIgnoreCaseOrRecipientOwnerIdAndStatusIsIgnoreCaseOrderBySwapDateDesc(
        OfferOwnerId: Long,
        status1: String,
        RecipientOwnerId: Long,
        status: String
    ): List<Swap>


    fun findAllByOfferOwnerIdAndStatusIsIgnoreCaseOrRecipientOwnerIdAndStatusIsIgnoreCaseOrderByCreatedDateDesc(
        OfferOwnerId: Long,
        status1: String,
        RecipientOwnerId: Long,
        status: String
    ): List<Swap>


}