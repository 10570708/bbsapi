
package com.bbs.bigbookswap.service

import com.bbs.bigbookswap.domain.Swap
import com.bbs.bigbookswap.dto.AddBookRequest
import com.bbs.bigbookswap.dto.BookResponse
import com.bbs.bigbookswap.dto.SwapRequest
import com.bbs.bigbookswap.dto.SwapResponse
import com.bbs.bigbookswap.transformer.toSwapResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface SwapManagementService {
   fun save(addBookRequest: SwapRequest): SwapResponse

   fun findMyRequests(id: Long): List<SwapResponse>

   fun findMyOffers(id: Long): List<SwapResponse>

   fun findAllByOwnerId(id: Long): List<SwapResponse>


   //fun getMyRequests(id: Long): <List<SwapResponse>>
}