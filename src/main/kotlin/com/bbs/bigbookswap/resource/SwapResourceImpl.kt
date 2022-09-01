package com.bbs.bigbookswap.resource

import com.bbs.bigbookswap.dto.SwapRequest
import com.bbs.bigbookswap.dto.SwapResponse
import com.bbs.bigbookswap.service.SwapManagementService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@CrossOrigin(origins = ["http://localhost:8080"])
@RestController
@RequestMapping(value = [SwapResourceImpl.BASE_SWAP_URL])
class SwapResourceImpl(private val swapManagementService: SwapManagementService) : SwapResource {

    @CrossOrigin(origins = ["http://localhost:4200"])
    @PostMapping
    override fun save(@RequestBody addSwapRequest: SwapRequest): ResponseEntity<SwapResponse> {
        val swapResponse = this.swapManagementService.save(addSwapRequest)
        return ResponseEntity
            .created(URI.create(BASE_SWAP_URL.plus("/${swapResponse.id}")))
            .body(swapResponse)
    }

    @CrossOrigin(origins = ["http://localhost:4200"])
    @PutMapping
    override fun update(@RequestBody updateSwapRequest: SwapRequest): ResponseEntity<SwapResponse> {
        val swapResponse = this.swapManagementService.update(updateSwapRequest)
        return ResponseEntity
            .created(URI.create(BASE_SWAP_URL.plus("/${swapResponse.id}")))
            .body(swapResponse)
    }

    @CrossOrigin(origins = ["http://localhost:4200"])
    @PutMapping("/complete")
    override fun complete(@RequestBody updateSwapRequest: SwapRequest): ResponseEntity<SwapResponse> {
        val swapResponse = this.swapManagementService.complete(updateSwapRequest)
        return ResponseEntity
            .created(URI.create(BASE_SWAP_URL.plus("/${swapResponse.id}")))
            .body(swapResponse)
    }

    @CrossOrigin(origins = ["http://localhost:4200"])
    @GetMapping("/requests/{id}")
    override fun findMyRequests(@PathVariable id: Long): ResponseEntity<List<SwapResponse>> {
        return ResponseEntity.ok(this.swapManagementService.findMyRequests(id))
    }


    @GetMapping("/pending/{id}")
    override fun findMyPendingById(@PathVariable id: Long): ResponseEntity<List<SwapResponse>> {
        return ResponseEntity.ok(this.swapManagementService.findMyPendingById(id))
    }

    @CrossOrigin(origins = ["http://localhost:4200"])
    @GetMapping("/complete/{id}")
    override fun findMyCompleteById(@PathVariable id: Long): ResponseEntity<List<SwapResponse>> {
        return ResponseEntity.ok(this.swapManagementService.findMyCompleteById(id))
    }

    @CrossOrigin(origins = ["http://localhost:4200"])
    @GetMapping("/offers/{id}")
    override fun findMyOffers(@PathVariable id: Long): ResponseEntity<List<SwapResponse>> {
        return ResponseEntity.ok(this.swapManagementService.findMyOffers(id))
    }

    @CrossOrigin(origins = ["http://localhost:4200"])
    @GetMapping("/all/{id}")
    override fun findAllByOwnerId(@PathVariable id: Long): ResponseEntity<List<SwapResponse>> {
        return ResponseEntity.ok(this.swapManagementService.findAllByOwnerId(id))
    }

    companion object {
        const val BASE_SWAP_URL: String = "/api/v1/swap"
    }

}