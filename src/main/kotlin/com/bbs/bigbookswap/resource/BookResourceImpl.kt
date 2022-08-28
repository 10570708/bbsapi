package com.bbs.bigbookswap.resource

import com.bbs.bigbookswap.dto.*
import com.bbs.bigbookswap.resource.BookResourceImpl.Companion.BASE_BOOK_URL
import com.bbs.bigbookswap.service.AuthValidation
import com.bbs.bigbookswap.service.BookManagementService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@CrossOrigin(origins = ["http://localhost:8080"])
@RestController
@RequestMapping(value= [BASE_BOOK_URL])
class BookResourceImpl(private val bookManagementService: BookManagementService, private val authManager: AuthValidation) : BookResource {

    @CrossOrigin(origins = ["http://localhost:4200"])
    @GetMapping("/{id}")
    override fun findById(@PathVariable id: Long): ResponseEntity<BookResponse> {
        val bookResponse = this.bookManagementService.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(bookResponse)
    }

    @CrossOrigin(origins = ["http://localhost:4200"])
    @GetMapping("/all")
    override fun findAll(@CookieValue("jwt") jwt:String?, pageable: Pageable): ResponseEntity<Page<BookResponse>>
    {
        println("Chcked the cookie and got ")
        println(authManager.validateCookie(jwt))
        return ResponseEntity.ok(this.bookManagementService.findAll(pageable))
    }

    @CrossOrigin(origins = ["http://localhost:4200"])
    @PostMapping
    override fun save(@RequestBody addBookRequest: AddBookRequest): ResponseEntity<BookResponse> {
        val bookResponse = this.bookManagementService.save( addBookRequest )
        return ResponseEntity
            .created(URI.create(BASE_BOOK_URL.plus("/${bookResponse.id}")))
            .body(bookResponse)
    }

    @GetMapping("/status/{status}")
    override fun findAllByStatus(@PathVariable status: String): ResponseEntity<List<BookResponse>> {

        return ResponseEntity.ok(this.bookManagementService.findAllByStatus(status))
    }

    @CrossOrigin(origins = ["http://localhost:4200"])
    @GetMapping("/option/{option}")
    override fun findAllByOption(@PathVariable option: String, pageable: Pageable): ResponseEntity<Page<BookResponse>> {

        return ResponseEntity.ok(this.bookManagementService.findAllByOption(option, pageable))
    }

    @CrossOrigin(origins = ["http://localhost:4200"])
    @GetMapping("/condition/{condition}")
    override fun findAllByCondition(@PathVariable condition: String, pageable: Pageable): ResponseEntity<Page<BookResponse>> {

        return ResponseEntity.ok(this.bookManagementService.findAllByCondition(condition, pageable))
    }

    @CrossOrigin(origins = ["http://localhost:4200"])
    @GetMapping("/owner/{id}/{match}")
    fun findAllByOwner(@PathVariable id: Long, @PathVariable match: Boolean, pageable: Pageable): ResponseEntity<Page<BookResponse>> {

        return if (match)
            this.findAllByOwnerId(id, pageable)
        else
            this.findAllByOwnerIdNot(id, pageable)
    }

    override fun findAllByOwnerId(ownerId: Long, pageable: Pageable): ResponseEntity<Page<BookResponse>> {
        return ResponseEntity.ok(this.bookManagementService.findAllByOwnerId(ownerId, pageable))
    }

    override fun findAllByOwnerIdNot(ownerId: Long, pageable: Pageable): ResponseEntity<Page<BookResponse>> {
        return ResponseEntity.ok(this.bookManagementService.findAllByOwnerIdNot(ownerId, pageable))
    }


    @CrossOrigin(origins = ["http://localhost:4200"])
    @GetMapping("/books/{search}")
    override fun findAllByAuthorContainsOrTitleContains(@PathVariable search: String,pageable: Pageable): ResponseEntity<Page<BookResponse>>{
        return ResponseEntity.ok(this.bookManagementService.findAllByAuthorContainsOrTitleContains(search,search,pageable))
    }

    @CrossOrigin(origins = ["http://localhost:4200"])
    @GetMapping("/ocosearch/{id}/{condition}/{option}")
    override fun findAllByOwnerConditionOption(@PathVariable id: Long, @PathVariable condition: String, @PathVariable option: String, pageable: Pageable): ResponseEntity<Page<BookResponse>>{
        return ResponseEntity.ok(this.bookManagementService.findAllByOwnerConditionOption(id,condition,option,pageable))
    }


    @CrossOrigin(origins = ["http://localhost:4200"])
    @GetMapping("/scosearch/{search}/{condition}/{option}")
    override fun findAllBySearchConditionOption(@PathVariable search: String, @PathVariable condition: String, @PathVariable option: String, pageable: Pageable): ResponseEntity<Page<BookResponse>>{
        return ResponseEntity.ok(this.bookManagementService.findAllBySearchConditionOption(search,condition,option,pageable))
    }

    @CrossOrigin(origins = ["http://localhost:4200"])
    @GetMapping("/scsearch/{search}/{condition}")
    override fun findAllBySearchCondition(@PathVariable search: String, @PathVariable condition: String, pageable: Pageable): ResponseEntity<Page<BookResponse>>{
        return ResponseEntity.ok(this.bookManagementService.findAllBySearchCondition(search,condition,pageable))
    }

    @CrossOrigin(origins = ["http://localhost:4200"])
    @GetMapping("/sosearch/{search}/{option}")
    override fun findAllBySearchOption(@PathVariable search: String, @PathVariable option: String, pageable: Pageable): ResponseEntity<Page<BookResponse>>{
        return ResponseEntity.ok(this.bookManagementService.findAllBySearchOption(search,option,pageable))
    }

    @CrossOrigin(origins = ["http://localhost:4200"])
    @GetMapping("/cosearch/{condition}/{option}")
    override fun findAllByConditionOption(@PathVariable condition: String, @PathVariable option: String, pageable: Pageable): ResponseEntity<Page<BookResponse>>{
        return ResponseEntity.ok(this.bookManagementService.findAllByConditionOption(condition,option,pageable))
    }

    @CrossOrigin(origins = ["http://localhost:4200"])
    @PutMapping("/{id}")
    override fun updateBook(@RequestBody updateBookRequest: AddBookRequest): ResponseEntity<BookResponse> {
        return ResponseEntity.ok(this.bookManagementService.updateBook(updateBookRequest))
    }

    @CrossOrigin(origins = ["http://localhost:4200"])
    @DeleteMapping("/{id}")
    override fun delete(@PathVariable id: Long): ResponseEntity<String> {
        this.bookManagementService.delete(id)
        return ResponseEntity.ok("done")
    }

//    @GetMapping("/avatars/{avatar}")
//    override fun findAllByTitleOrAuthor(@PathVariable avatar: String): ResponseEntity<List<BookResponse>> {
//
//        return ResponseEntity.ok(this.bookManagementService.findByAvatar(avatar))
//    }

    companion object {
        const val BASE_BOOK_URL: String = "/api/v1/book"
    }
}
