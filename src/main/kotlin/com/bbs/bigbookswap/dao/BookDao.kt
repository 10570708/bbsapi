package com.bbs.bigbookswap.dao

import com.bbs.bigbookswap.domain.Book
import com.bbs.bigbookswap.dto.BookResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookDao: JpaRepository<Book, Long> {

    fun findAllByAuthorIgnoreCaseContainsOrTitleIgnoreCaseContains(author: String, title: String,pageable: Pageable): Page<BookResponse>
    fun findAllByOwnerIdAndStatusIgnoreCase(ownerId: Long, status: String): List<BookResponse>
    fun findAllByOwnerId(id: Long, pageable: Pageable): Page<BookResponse>
    fun findByOwnerIdNot(id: Long, pageable: Pageable): Page<BookResponse>
    fun findAllByAuthorIgnoreCaseContainsOrTitleIgnoreCaseContainsAndOwnerId(author: String, title: String, id: Long, pageable: Pageable): Page<BookResponse>
    fun findAllByAuthorIgnoreCaseContainsOrTitleIgnoreCaseContainsAndOwnerIdNot(author: String, title: String, id: Long, pageable: Pageable): Page<BookResponse>

    fun findAllByAuthorIgnoreCaseContainsOrTitleIgnoreCaseContainsAndConditionIgnoreCaseAndOptionIgnoreCaseAndOwnerId(author: String, title: String, condition: String, option: String, id: Long, pageable: Pageable): Page<BookResponse>
    fun findAllByAuthorIgnoreCaseContainsOrTitleIgnoreCaseContainsAndConditionIgnoreCaseAndOptionIgnoreCaseAndOwnerIdNot(author: String, title: String, condition: String, option: String, id: Long, pageable: Pageable): Page<BookResponse>
    fun findAllByConditionIgnoreCaseAndOwnerId(condition: String, id: Long, pageable: Pageable): Page<BookResponse>
    fun findAllByConditionIgnoreCaseAndOwnerIdNot(condition: String, id: Long, pageable: Pageable): Page<BookResponse>
    fun findAllByOptionIgnoreCaseAndOwnerId(option: String, id: Long, pageable: Pageable): Page<BookResponse>
    fun findAllByOptionIgnoreCaseAndOwnerIdNot(option: String, id: Long, pageable: Pageable): Page<BookResponse>
    fun findAllByAuthorIgnoreCaseContainsOrTitleIgnoreCaseContainsAndConditionIgnoreCaseAndOwnerId(author: String, title: String, condition: String, id: Long, pageable: Pageable): Page<BookResponse>
    fun findAllByAuthorIgnoreCaseContainsOrTitleIgnoreCaseContainsAndConditionIgnoreCaseAndOwnerIdNot(author: String, title: String, condition: String, id: Long, pageable: Pageable): Page<BookResponse>
    fun findAllByAuthorIgnoreCaseContainsOrTitleIgnoreCaseContainsAndOptionIgnoreCaseAndOwnerId(author: String, title: String, option: String, id: Long, pageable: Pageable): Page<BookResponse>
    fun findAllByAuthorIgnoreCaseContainsOrTitleIgnoreCaseContainsAndOptionIgnoreCaseAndOwnerIdNot(author: String, title: String, option: String, id: Long, pageable: Pageable): Page<BookResponse>
    fun findAllByAuthorIgnoreCaseContainsOrTitleIgnoreCaseContainsAndConditionIgnoreCase(author: String, title: String, condition: String,  pageable: Pageable): Page<BookResponse>
    fun findAllByAuthorIgnoreCaseContainsOrTitleIgnoreCaseContainsAndOptionIgnoreCase(author: String, title: String, option: String,  pageable: Pageable): Page<BookResponse>
    fun findAllByConditionIgnoreCaseAndOptionIgnoreCase(option: String,  condition: String, pageable: Pageable): Page<BookResponse>


    fun findAllByConditionIgnoreCaseAndOptionIgnoreCaseAndOwnerId(condition: String, option: String, id: Long, pageable: Pageable): Page<BookResponse>
    fun findAllByConditionIgnoreCaseAndOptionIgnoreCaseAndOwnerIdNot(condition: String, option: String, id: Long, pageable: Pageable): Page<BookResponse>

    fun findAllByAuthorIgnoreCaseContainsOrTitleIgnoreCaseContainsAndConditionIgnoreCaseAndOptionIgnoreCase(author: String, title: String, condition: String, option: String, pageable: Pageable): Page<BookResponse>

    fun findAllByConditionIgnoreCase(condition: String, pageable: Pageable): Page<BookResponse>
    fun findAllByStatus(status: String): List<Book>
    fun findAllByOptionIgnoreCase(option: String, pageable: Pageable): Page<BookResponse>
    fun findAllByAuthorContainsOrTitleContainsAndStatusIs(author:String, title:String,status:String)



}