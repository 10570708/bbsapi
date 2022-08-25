package com.bbs.bigbookswap.service

import com.bbs.bigbookswap.dto.*
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface BookManagementService {
    fun findById(id: Long): BookResponse?
    fun findAll(pageable: Pageable): Page<BookResponse>
    fun save(addBookRequest: AddBookRequest): BookResponse
    fun updateBook(addBookRequest: AddBookRequest): BookResponse
    fun delete(id:Long)
    fun findAllByAuthorContainsOrTitleContains(searchString:String,searchString2:String,pageable: Pageable): Page<BookResponse>
    fun findAllByOwnerConditionOption(owner: Long, condition: String, option: String,pageable: Pageable): Page<BookResponse>
    fun findAllBySearchConditionOption(search: String, condition: String, option: String,pageable: Pageable): Page<BookResponse>
    fun findAllBySearchCondition(search: String, condition: String, pageable: Pageable): Page<BookResponse>
    fun findAllBySearchOption(search: String, option: String, pageable: Pageable): Page<BookResponse>
    fun findAllByConditionOption(condition: String, option: String, pageable: Pageable): Page<BookResponse>

    fun findAllByOwnerId(owner: Long, pageable: Pageable): Page<BookResponse>
    fun findAllByOwnerIdNot(owner: Long, pageable: Pageable): Page<BookResponse>

    fun findAllByStatus(status: String): List<BookResponse>
    fun findAllByOption(option: String, pageable: Pageable): Page<BookResponse>
    fun findAllByCondition(condition: String, pageable: Pageable): Page<BookResponse>

}