package com.bbs.bigbookswap.resource

import com.bbs.bigbookswap.dto.AddBookRequest
import com.bbs.bigbookswap.dto.BookResponse
import com.bbs.bigbookswap.dto.UpdateBookRequest
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
@RequestMapping(value = [BASE_BOOK_URL])
class BookResourceImpl(
    private val bookManagementService: BookManagementService,
    private val authManager: AuthValidation
) : BookResource {

    @CrossOrigin(origins = ["http://localhost:4200"])
    @GetMapping("/{id}")
    override fun findById(@PathVariable id: Long): ResponseEntity<BookResponse> {
        val bookResponse = this.bookManagementService.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(bookResponse)
    }

    @CrossOrigin(origins = ["http://localhost:4200"])
    @GetMapping("/all")
    override fun findAll(@CookieValue("jwt") jwt: String?, pageable: Pageable): ResponseEntity<Page<BookResponse>> {
        return ResponseEntity.ok(this.bookManagementService.findAll(pageable))
    }

    @CrossOrigin(origins = ["http://localhost:4200"])
    @PostMapping
    override fun save(@RequestBody addBookRequest: AddBookRequest): ResponseEntity<BookResponse> {
        val bookResponse = this.bookManagementService.save(addBookRequest)
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
    override fun findAllByCondition(
        @PathVariable condition: String,
        pageable: Pageable
    ): ResponseEntity<Page<BookResponse>> {

        return ResponseEntity.ok(this.bookManagementService.findAllByCondition(condition, pageable))
    }

    @CrossOrigin(origins = ["http://localhost:4200"])
    @GetMapping("/available/owner/{id}")
    override fun findAllByOwnerIdAndStatus(@PathVariable id: Long): ResponseEntity<List<BookResponse>> {

        return ResponseEntity.ok(this.bookManagementService.findAllByOwnerIdAndStatus(id, "available"))

    }

    @CrossOrigin(origins = ["http://localhost:4200"])
    @GetMapping("/owner/{id}/{match}")
    fun findAllByOwner(
        @PathVariable id: Long,
        @PathVariable match: Boolean,
        pageable: Pageable
    ): ResponseEntity<Page<BookResponse>> {

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
    @GetMapping("/searchowner/{search}/{id}/{match}")
    fun findAllBySearchOwner(
        @PathVariable search: String,
        @PathVariable id: Long,
        @PathVariable match: Boolean,
        pageable: Pageable
    ): ResponseEntity<Page<BookResponse>> {

        return if (match)
            this.findAllBySearchOwnerId(search, id, pageable)
        else
            this.findAllBySearchOwnerIdNot(search, id, pageable)
    }


    override fun findAllBySearchOwnerId(
        search: String,
        ownerId: Long,
        pageable: Pageable
    ): ResponseEntity<Page<BookResponse>> {
        return ResponseEntity.ok(this.bookManagementService.findAllBySearchOwnerId(search, ownerId, pageable))
    }

    override fun findAllBySearchOwnerIdNot(
        search: String,
        ownerId: Long,
        pageable: Pageable
    ): ResponseEntity<Page<BookResponse>> {
        return ResponseEntity.ok(this.bookManagementService.findAllBySearchOwnerIdNot(search, ownerId, pageable))
    }


    @CrossOrigin(origins = ["http://localhost:4200"])
    @GetMapping("/allfilters/{search}/{condition}/{option}/{id}/{match}")
    fun findAllBySearchConditionOptionOwner(
        @PathVariable search: String,
        @PathVariable condition: String,
        @PathVariable option: String,
        @PathVariable id: Long,
        @PathVariable match: Boolean,
        pageable: Pageable
    ): ResponseEntity<Page<BookResponse>> {

        return if (match)
            this.findAllBySearchConditionOptionOwnerId(search, condition, option, id, pageable)
        else
            this.findAllBySearchConditionOptionOwnerIdNot(search, condition, option, id, pageable)
    }


    override fun findAllBySearchConditionOptionOwnerId(
        search: String,
        condition: String,
        option: String,
        ownerId: Long,
        pageable: Pageable
    ): ResponseEntity<Page<BookResponse>> {
        return ResponseEntity.ok(
            this.bookManagementService.findAllBySearchConditionOptionOwnerId(
                search,
                condition,
                option,
                ownerId,
                pageable
            )
        )
    }

    override fun findAllBySearchConditionOptionOwnerIdNot(
        search: String,
        condition: String,
        option: String,
        ownerId: Long,
        pageable: Pageable
    ): ResponseEntity<Page<BookResponse>> {
        return ResponseEntity.ok(
            this.bookManagementService.findAllBySearchConditionOptionOwnerIdNot(
                search,
                condition,
                option,
                ownerId,
                pageable
            )
        )
    }


    @CrossOrigin(origins = ["http://localhost:4200"])
    @GetMapping(
        "/searchconditionowner" +
                "/{search}/{condition}/{id}/{match}"
    )
    fun findAllBySearchConditionOwner(
        @PathVariable search: String,
        @PathVariable condition: String,
        @PathVariable id: Long,
        @PathVariable match: Boolean,
        pageable: Pageable
    ): ResponseEntity<Page<BookResponse>> {

        return if (match)
            this.findAllBySearchConditionOwnerId(search, condition, id, pageable)
        else
            this.findAllBySearchConditionOwnerIdNot(search, condition, id, pageable)
    }


    override fun findAllBySearchConditionOwnerId(
        search: String,
        condition: String,
        ownerId: Long,
        pageable: Pageable
    ): ResponseEntity<Page<BookResponse>> {
        return ResponseEntity.ok(
            this.bookManagementService.findAllBySearchConditionOwnerId(
                search,
                condition,
                ownerId,
                pageable
            )
        )
    }


    override fun findAllBySearchConditionOwnerIdNot(
        search: String,
        condition: String,
        ownerId: Long,
        pageable: Pageable
    ): ResponseEntity<Page<BookResponse>> {
        return ResponseEntity.ok(
            this.bookManagementService.findAllBySearchConditionOwnerIdNot(
                search,
                condition,
                ownerId,
                pageable
            )
        )
    }

    @CrossOrigin(origins = ["http://localhost:4200"])
    @GetMapping(
        "/conditionowner" +
                "/{condition}/{id}/{match}"
    )
    fun findAllByConditionOwner(
        @PathVariable condition: String,
        @PathVariable id: Long,
        @PathVariable match: Boolean,
        pageable: Pageable
    ): ResponseEntity<Page<BookResponse>> {

        return if (match)
            this.findAllByConditionOwnerId(condition, id, pageable)
        else
            this.findAllByConditionOwnerIdNot(condition, id, pageable)
    }


    override fun findAllByConditionOwnerId(
        condition: String,
        ownerId: Long,
        pageable: Pageable
    ): ResponseEntity<Page<BookResponse>> {
        return ResponseEntity.ok(this.bookManagementService.findAllByConditionOwnerId(condition, ownerId, pageable))
    }

    override fun findAllByConditionOwnerIdNot(
        condition: String,
        ownerId: Long,
        pageable: Pageable
    ): ResponseEntity<Page<BookResponse>> {
        return ResponseEntity.ok(this.bookManagementService.findAllByConditionOwnerIdNot(condition, ownerId, pageable))
    }


    @CrossOrigin(origins = ["http://localhost:4200"])
    @GetMapping(
        "/optionowner" +
                "/{option}/{id}/{match}"
    )
    fun findAllByOptionOwner(
        @PathVariable option: String,
        @PathVariable id: Long,
        @PathVariable match: Boolean,
        pageable: Pageable
    ): ResponseEntity<Page<BookResponse>> {

        return if (match)
            this.findAllByOptionOwnerId(option, id, pageable)
        else
            this.findAllByOptionOwnerIdNot(option, id, pageable)
    }


    override fun findAllByOptionOwnerId(
        option: String,
        ownerId: Long,
        pageable: Pageable
    ): ResponseEntity<Page<BookResponse>> {
        return ResponseEntity.ok(this.bookManagementService.findAllByOptionOwnerId(option, ownerId, pageable))
    }

    override fun findAllByOptionOwnerIdNot(
        option: String,
        ownerId: Long,
        pageable: Pageable
    ): ResponseEntity<Page<BookResponse>> {
        return ResponseEntity.ok(this.bookManagementService.findAllByOptionOwnerIdNot(option, ownerId, pageable))
    }


    @CrossOrigin(origins = ["http://localhost:4200"])
    @GetMapping(
        "/searchoptionowner" +
                "/{search}/{option}/{id}/{match}"
    )
    fun findAllBySearchOptionOwner(
        @PathVariable search: String,
        @PathVariable option: String,
        @PathVariable id: Long,
        @PathVariable match: Boolean,
        pageable: Pageable
    ): ResponseEntity<Page<BookResponse>> {

        return if (match)
            this.findAllBySearchOptionOwnerId(search, option, id, pageable)
        else
            this.findAllBySearchOptionOwnerIdNot(search, option, id, pageable)
    }


    override fun findAllBySearchOptionOwnerId(
        search: String,
        option: String,
        ownerId: Long,
        pageable: Pageable
    ): ResponseEntity<Page<BookResponse>> {
        return ResponseEntity.ok(
            this.bookManagementService.findAllBySearchOptionOwnerId(
                search,
                option,
                ownerId,
                pageable
            )
        )
    }

    override fun findAllBySearchOptionOwnerIdNot(
        search: String,
        option: String,
        ownerId: Long,
        pageable: Pageable
    ): ResponseEntity<Page<BookResponse>> {
        return ResponseEntity.ok(
            this.bookManagementService.findAllBySearchOptionOwnerIdNot(
                search,
                option,
                ownerId,
                pageable
            )
        )
    }


    @CrossOrigin(origins = ["http://localhost:4200"])
    @GetMapping("/books/{search}")
    override fun findAllByAuthorContainsOrTitleContains(
        @PathVariable search: String,
        pageable: Pageable
    ): ResponseEntity<Page<BookResponse>> {
        return ResponseEntity.ok(
            this.bookManagementService.findAllByAuthorContainsOrTitleContains(
                search,
                search,
                pageable
            )
        )
    }

    @CrossOrigin(origins = ["http://localhost:4200"])
    @GetMapping("/conditionoptionowner/{condition}/{option}/{id}/{match}")
    fun findAllByConditionOptionOwner(
        @PathVariable condition: String,
        @PathVariable option: String,
        @PathVariable id: Long,
        @PathVariable match: Boolean,
        pageable: Pageable
    ): ResponseEntity<Page<BookResponse>> {

        return if (match)
            this.findAllByConditionOptionOwnerId(condition, option, id, pageable)
        else
            this.findAllByConditionOptionOwnerIdNot(condition, option, id, pageable)
    }


    override fun findAllByConditionOptionOwnerId(
        condition: String,
        option: String,
        ownerId: Long,
        pageable: Pageable
    ): ResponseEntity<Page<BookResponse>> {
        return ResponseEntity.ok(
            this.bookManagementService.findAllByConditionOptionOwnerId(
                condition,
                option,
                ownerId,
                pageable
            )
        )
    }

    override fun findAllByConditionOptionOwnerIdNot(
        condition: String,
        option: String,
        ownerId: Long,
        pageable: Pageable
    ): ResponseEntity<Page<BookResponse>> {
        return ResponseEntity.ok(
            this.bookManagementService.findAllByConditionOptionOwnerIdNot(
                condition,
                option,
                ownerId,
                pageable
            )
        )
    }


    @CrossOrigin(origins = ["http://localhost:4200"])
    @GetMapping("/searchconditionoption/{search}/{condition}/{option}")
    override fun findAllBySearchConditionOption(
        @PathVariable search: String,
        @PathVariable condition: String,
        @PathVariable option: String,
        pageable: Pageable
    ): ResponseEntity<Page<BookResponse>> {
        return ResponseEntity.ok(
            this.bookManagementService.findAllBySearchConditionOption(
                search,
                condition,
                option,
                pageable
            )
        )
    }

    @CrossOrigin(origins = ["http://localhost:4200"])
    @GetMapping("/searchcondition/{search}/{condition}")
    override fun findAllBySearchCondition(
        @PathVariable search: String,
        @PathVariable condition: String,
        pageable: Pageable
    ): ResponseEntity<Page<BookResponse>> {
        return ResponseEntity.ok(this.bookManagementService.findAllBySearchCondition(search, condition, pageable))
    }

    @CrossOrigin(origins = ["http://localhost:4200"])
    @GetMapping("/searchoption/{search}/{option}")
    override fun findAllBySearchOption(
        @PathVariable search: String,
        @PathVariable option: String,
        pageable: Pageable
    ): ResponseEntity<Page<BookResponse>> {
        return ResponseEntity.ok(this.bookManagementService.findAllBySearchOption(search, option, pageable))
    }

    @CrossOrigin(origins = ["http://localhost:4200"])
    @GetMapping("/conditionoption/{condition}/{option}")
    override fun findAllByConditionOption(
        @PathVariable condition: String,
        @PathVariable option: String,
        pageable: Pageable
    ): ResponseEntity<Page<BookResponse>> {
        return ResponseEntity.ok(this.bookManagementService.findAllByConditionOption(condition, option, pageable))
    }

    @CrossOrigin(origins = ["http://localhost:4200"])
    @PutMapping("/{id}")
    override fun updateBook(@RequestBody updateBookRequest: UpdateBookRequest): ResponseEntity<BookResponse> {
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
