// Written By: Lisa Daly (StudentID: 10570708) - DBS 2022 Final Project B8IT131_2122_TME2 //
// Definition of the SwapResource Interface

package com.bbs.bigbookswap.resource

import com.bbs.bigbookswap.dto.SwapRequest
import com.bbs.bigbookswap.dto.SwapResponse
import org.springframework.http.ResponseEntity

interface SwapResource {

    fun save(addSwapRequest: SwapRequest): ResponseEntity<SwapResponse>
    fun update(updateSwapRequest: SwapRequest): ResponseEntity<SwapResponse>
    fun complete(updateSwapRequest: SwapRequest): ResponseEntity<SwapResponse>
    fun findMyRequests(id: Long): ResponseEntity<List<SwapResponse>>
    fun findMyOffers(id: Long): ResponseEntity<List<SwapResponse>>
    fun findMyPendingById(id: Long): ResponseEntity<List<SwapResponse>>
    fun findMyCompleteById(id: Long): ResponseEntity<List<SwapResponse>>
    fun findAllByOwnerId(id: Long): ResponseEntity<List<SwapResponse>>
}