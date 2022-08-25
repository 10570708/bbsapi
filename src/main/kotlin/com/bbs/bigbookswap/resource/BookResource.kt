package com.bbs.bigbookswap.resource

import com.bbs.bigbookswap.domain.Book
import com.bbs.bigbookswap.dto.AddBookRequest
import com.bbs.bigbookswap.dto.AddUserRequest
import com.bbs.bigbookswap.dto.BookResponse
import com.bbs.bigbookswap.dto.UpdateUserRequest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity

interface BookResource {
    fun findById(id: Long): ResponseEntity<BookResponse>
    fun findAllByAuthorContainsOrTitleContains(searchAuthor: String,pageable: org.springframework.data.domain.Pageable): ResponseEntity<Page<BookResponse>>
    fun findAllByOwnerId(ownerId: Long, pageable: Pageable): ResponseEntity<Page<BookResponse>>
    fun findAllByOwnerIdNot(ownerId: Long, pageable: Pageable): ResponseEntity<Page<BookResponse>>

    fun findAllByOwnerConditionOption(owner: Long, condition: String, option: String,pageable: org.springframework.data.domain.Pageable): ResponseEntity<Page<BookResponse>>
    fun findAllBySearchConditionOption(search: String, condition: String, option: String,pageable: org.springframework.data.domain.Pageable): ResponseEntity<Page<BookResponse>>

    fun findAllByConditionOption(condition: String, option: String,pageable: org.springframework.data.domain.Pageable): ResponseEntity<Page<BookResponse>>
    fun findAllBySearchCondition(search: String, condition: String,pageable: org.springframework.data.domain.Pageable): ResponseEntity<Page<BookResponse>>
    fun findAllBySearchOption(search: String, option: String,pageable: org.springframework.data.domain.Pageable): ResponseEntity<Page<BookResponse>>


    //fun findAllByStatus(avatar: String): ResponseEntity<List<BookResponse>>
    fun findAll(pageable: org.springframework.data.domain.Pageable): ResponseEntity<Page<BookResponse>>
    fun save(addBookRequest: AddBookRequest): ResponseEntity<BookResponse>
    fun updateBook(updateBookRequest: AddBookRequest): ResponseEntity<BookResponse>
    fun delete(id:Long): ResponseEntity<String>
    //fun findAllByOwnerId(id: Long): ResponseEntity<List<BookResponse>>
    fun findAllByStatus(status: String): ResponseEntity<List<BookResponse>>
    fun findAllByCondition(status: String, pageable: Pageable): ResponseEntity<Page<BookResponse>>

    fun findAllByOption(option: String, pageable: Pageable): ResponseEntity<Page<BookResponse>>

}