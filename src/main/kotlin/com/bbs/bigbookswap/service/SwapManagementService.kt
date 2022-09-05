// Written By: Lisa Daly (StudentID: 10570708) - DBS 2022 Final Project B8IT131_2122_TME2 //
// Definition of the SwapManagement Service Interface and all the Methods it defines

package com.bbs.bigbookswap.service

import com.bbs.bigbookswap.dto.SwapRequest
import com.bbs.bigbookswap.dto.SwapResponse

interface SwapManagementService {
    fun save(addSwapRequest: SwapRequest): SwapResponse
    fun update(updateSwapRequest: SwapRequest): SwapResponse
    fun complete(updateSwapRequest: SwapRequest): SwapResponse
    fun findMyRequests(id: Long): List<SwapResponse>
    fun findMyPendingById(id: Long): List<SwapResponse>
    fun findMyCompleteById(id: Long): List<SwapResponse>
    fun findMyOffers(id: Long): List<SwapResponse>
    fun findAllByOwnerId(id: Long): List<SwapResponse>
}