package com.bbs.bigbookswap.resource

import com.bbs.bigbookswap.domain.BBSUser
import com.bbs.bigbookswap.dto.*
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import javax.servlet.http.HttpServletResponse

interface SwapResource {

    fun save(addSwapRequest: SwapRequest): ResponseEntity<SwapResponse>

    fun findMyRequests(id: Long): ResponseEntity<List<SwapResponse>>
    fun findMyOffers(id: Long): ResponseEntity<List<SwapResponse>>
    fun findAllByOwnerId(id: Long): ResponseEntity<List<SwapResponse>>

}