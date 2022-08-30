package com.bbs.bigbookswap.dao

import com.bbs.bigbookswap.domain.Swap
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SwapDao: JpaRepository<Swap, Long> {

    fun findByOfferOwnerId(id: Long): List<Swap>

    fun findAllByRecipientOwnerIdOrOfferOwnerId(RecipientOwnerId: Long, OfferOwnerId: Long): List<Swap>

    fun findByRecipientOwnerId(id: Long): List<Swap>

}