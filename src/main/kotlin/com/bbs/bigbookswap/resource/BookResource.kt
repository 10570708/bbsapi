// Written By: Lisa Daly (StudentID: 10570708) - DBS 2022 Final Project B8IT131_2122_TME2 //
// Definition of the BookResource Interface

package com.bbs.bigbookswap.resource

import com.bbs.bigbookswap.dto.AddBookRequest
import com.bbs.bigbookswap.dto.BookResponse
import com.bbs.bigbookswap.dto.UpdateBookRequest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity

interface BookResource {
    fun findById(id: Long): ResponseEntity<BookResponse>
    fun findAllByOwnerIdAndStatus(ownerId: Long): ResponseEntity<List<BookResponse>>
    fun findAllByAuthorContainsOrTitleContains(
        searchAuthor: String,
        pageable: Pageable
    ): ResponseEntity<Page<BookResponse>>

    fun findAllByOwnerId(ownerId: Long, pageable: Pageable): ResponseEntity<Page<BookResponse>>
    fun findAllByOwnerIdNot(ownerId: Long, pageable: Pageable): ResponseEntity<Page<BookResponse>>
    fun findAllBySearchOwnerId(search: String, ownerId: Long, pageable: Pageable): ResponseEntity<Page<BookResponse>>
    fun findAllBySearchOwnerIdNot(search: String, ownerId: Long, pageable: Pageable): ResponseEntity<Page<BookResponse>>
    fun findAllBySearchConditionOptionOwnerId(
        search: String,
        condition: String,
        option: String,
        ownerId: Long,
        pageable: Pageable
    ): ResponseEntity<Page<BookResponse>>

    fun findAllBySearchConditionOptionOwnerIdNot(
        search: String,
        condition: String,
        option: String,
        ownerId: Long,
        pageable: Pageable
    ): ResponseEntity<Page<BookResponse>>

    fun findAllBySearchConditionOwnerId(
        search: String,
        condition: String,
        ownerId: Long,
        pageable: Pageable
    ): ResponseEntity<Page<BookResponse>>

    fun findAllBySearchConditionOwnerIdNot(
        search: String,
        condition: String,
        ownerId: Long,
        pageable: Pageable
    ): ResponseEntity<Page<BookResponse>>

    fun findAllByConditionOwnerId(
        condition: String,
        ownerId: Long,
        pageable: Pageable
    ): ResponseEntity<Page<BookResponse>>

    fun findAllByConditionOwnerIdNot(
        condition: String,
        ownerId: Long,
        pageable: Pageable
    ): ResponseEntity<Page<BookResponse>>

    fun findAllByOptionOwnerId(option: String, ownerId: Long, pageable: Pageable): ResponseEntity<Page<BookResponse>>
    fun findAllByOptionOwnerIdNot(option: String, ownerId: Long, pageable: Pageable): ResponseEntity<Page<BookResponse>>
    fun findAllBySearchOptionOwnerId(
        search: String,
        option: String,
        ownerId: Long,
        pageable: Pageable
    ): ResponseEntity<Page<BookResponse>>

    fun findAllBySearchOptionOwnerIdNot(
        search: String,
        option: String,
        ownerId: Long,
        pageable: Pageable
    ): ResponseEntity<Page<BookResponse>>

    fun findAllByConditionOptionOwnerId(
        condition: String,
        option: String,
        owner: Long,
        pageable: Pageable
    ): ResponseEntity<Page<BookResponse>>

    fun findAllByConditionOptionOwnerIdNot(
        condition: String,
        option: String,
        owner: Long,
        pageable: Pageable
    ): ResponseEntity<Page<BookResponse>>

    fun findAllBySearchConditionOption(
        search: String,
        condition: String,
        option: String,
        pageable: Pageable
    ): ResponseEntity<Page<BookResponse>>

    fun findAllByConditionOption(
        condition: String,
        option: String,
        pageable: Pageable
    ): ResponseEntity<Page<BookResponse>>

    fun findAllBySearchCondition(
        search: String,
        condition: String,
        pageable: Pageable
    ): ResponseEntity<Page<BookResponse>>

    fun findAllBySearchOption(
        search: String,
        option: String,
        pageable: Pageable
    ): ResponseEntity<Page<BookResponse>>


    fun findAll(jwt: String?, pageable: Pageable): ResponseEntity<Page<BookResponse>>
    fun save(addBookRequest: AddBookRequest): ResponseEntity<BookResponse>
    fun updateBook(updateBookRequest: UpdateBookRequest): ResponseEntity<BookResponse>
    fun delete(id: Long): ResponseEntity<String>

    fun findAllByStatus(status: String): ResponseEntity<List<BookResponse>>
    fun findAllByCondition(condition: String, pageable: Pageable): ResponseEntity<Page<BookResponse>>

    fun findAllByOption(option: String, pageable: Pageable): ResponseEntity<Page<BookResponse>>

}