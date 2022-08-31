package com.bbs.bigbookswap.dao

import com.bbs.bigbookswap.domain.Swap
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface SwapDao: JpaRepository<Swap, Long> {

    fun findByOfferOwnerIdAndStatusIgnoreCase(id: Long,status: String): List<Swap>

    fun findAllByOfferOwnerIdAndStatusIsIgnoreCaseOrRecipientOwnerIdAndStatusIsIgnoreCase(OfferOwnerId: Long, status1: String, RecipientOwnerId: Long, status: String): List<Swap>
    fun findAllByRecipientOwnerIdOrOfferOwnerId(RecipientOwnerId: Long, OfferOwnerId: Long): List<Swap>

    fun findByRecipientOwnerIdAndStatusIgnoreCase(id: Long, status: String): List<Swap>

}