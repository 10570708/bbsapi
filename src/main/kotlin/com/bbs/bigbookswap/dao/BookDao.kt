// Written By: Lisa Daly (StudentID: 10570708) - DBS 2022 Final Project B8IT131_2122_TME2 //
// Contains the custom JPA Repository queries for Books - particularly by search criteria :
// Author/Title Search | Status | Condition | Option

package com.bbs.bigbookswap.dao

import com.bbs.bigbookswap.domain.Book
import com.bbs.bigbookswap.dto.BookResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookDao : JpaRepository<Book, Long> {

    fun findAllByOrderByAddedDateDesc(pageable: Pageable): Page<BookResponse>
    fun findAllByStatusOrderByAddedDateDesc(status: String): List<Book>
    fun findAllByConditionIgnoreCaseOrderByAddedDateDesc(condition: String, pageable: Pageable): Page<BookResponse>
    fun findAllByOptionIgnoreCaseOrderByAddedDateDesc(option: String, pageable: Pageable): Page<BookResponse>
    fun findAllByOwnerIdAndStatusIgnoreCaseOrderByAddedDateDesc(ownerId: Long, status: String): List<BookResponse>
    fun findAllByOwnerIdOrderByAddedDateDesc(id: Long, pageable: Pageable): Page<BookResponse>
    fun findByOwnerIdNotOrderByAddedDateDesc(id: Long, pageable: Pageable): Page<BookResponse>
    fun findAllByConditionIgnoreCaseAndOwnerIdOrderByAddedDateDesc(condition: String, id: Long, pageable: Pageable): Page<BookResponse>
    fun findAllByConditionIgnoreCaseAndOwnerIdNotOrderByAddedDateDesc(condition: String, id: Long, pageable: Pageable): Page<BookResponse>
    fun findAllByOptionIgnoreCaseAndOwnerIdOrderByAddedDateDesc(option: String, id: Long, pageable: Pageable): Page<BookResponse>
    fun findAllByOptionIgnoreCaseAndOwnerIdNotOrderByAddedDateDesc(option: String, id: Long, pageable: Pageable): Page<BookResponse>
    fun findAllByAuthorIgnoreCaseContainsOrTitleIgnoreCaseContainsOrderByAddedDateDesc(
        author: String,
        title: String,
        pageable: Pageable
    ): Page<BookResponse>

    fun findAllByAuthorIgnoreCaseContainsOrTitleIgnoreCaseContainsAndOwnerIdOrderByAddedDateDesc(
        author: String,
        title: String,
        id: Long,
        pageable: Pageable
    ): Page<BookResponse>

    fun findAllByAuthorIgnoreCaseContainsOrTitleIgnoreCaseContainsAndOwnerIdNotOrderByAddedDateDesc(
        author: String,
        title: String,
        id: Long,
        pageable: Pageable
    ): Page<BookResponse>

    fun findAllByAuthorIgnoreCaseContainsOrTitleIgnoreCaseContainsAndConditionIgnoreCaseAndOptionIgnoreCaseAndOwnerIdOrderByAddedDateDesc(
        author: String,
        title: String,
        condition: String,
        option: String,
        id: Long,
        pageable: Pageable
    ): Page<BookResponse>

    fun findAllByAuthorIgnoreCaseContainsOrTitleIgnoreCaseContainsAndConditionIgnoreCaseAndOptionIgnoreCaseAndOwnerIdNotOrderByAddedDateDesc(
        author: String,
        title: String,
        condition: String,
        option: String,
        id: Long,
        pageable: Pageable
    ): Page<BookResponse>


    fun findAllByAuthorIgnoreCaseContainsOrTitleIgnoreCaseContainsAndConditionIgnoreCaseAndOwnerIdOrderByAddedDateDesc(
        author: String,
        title: String,
        condition: String,
        id: Long,
        pageable: Pageable
    ): Page<BookResponse>

    fun findAllByAuthorIgnoreCaseContainsOrTitleIgnoreCaseContainsAndConditionIgnoreCaseAndOwnerIdNotOrderByAddedDateDesc(
        author: String,
        title: String,
        condition: String,
        id: Long,
        pageable: Pageable
    ): Page<BookResponse>

    fun findAllByAuthorIgnoreCaseContainsOrTitleIgnoreCaseContainsAndOptionIgnoreCaseAndOwnerIdOrderByAddedDateDesc(
        author: String,
        title: String,
        option: String,
        id: Long,
        pageable: Pageable
    ): Page<BookResponse>

    fun findAllByAuthorIgnoreCaseContainsOrTitleIgnoreCaseContainsAndOptionIgnoreCaseAndOwnerIdNotOrderByAddedDateDesc(
        author: String,
        title: String,
        option: String,
        id: Long,
        pageable: Pageable
    ): Page<BookResponse>

    fun findAllByAuthorIgnoreCaseContainsOrTitleIgnoreCaseContainsAndConditionIgnoreCaseOrderByAddedDateDesc(
        author: String,
        title: String,
        condition: String,
        pageable: Pageable
    ): Page<BookResponse>

    fun findAllByAuthorIgnoreCaseContainsOrTitleIgnoreCaseContainsAndOptionIgnoreCaseOrderByAddedDateDesc(
        author: String,
        title: String,
        option: String,
        pageable: Pageable
    ): Page<BookResponse>

    fun findAllByConditionIgnoreCaseAndOptionIgnoreCaseOrderByAddedDateDesc(
        option: String,
        condition: String,
        pageable: Pageable
    ): Page<BookResponse>


    fun findAllByConditionIgnoreCaseAndOptionIgnoreCaseAndOwnerIdOrderByAddedDateDesc(
        condition: String,
        option: String,
        id: Long,
        pageable: Pageable
    ): Page<BookResponse>

    fun findAllByConditionIgnoreCaseAndOptionIgnoreCaseAndOwnerIdNotOrderByAddedDateDesc(
        condition: String,
        option: String,
        id: Long,
        pageable: Pageable
    ): Page<BookResponse>

    fun findAllByAuthorIgnoreCaseContainsOrTitleIgnoreCaseContainsAndConditionIgnoreCaseAndOptionIgnoreCaseOrderByAddedDateDesc(
        author: String,
        title: String,
        condition: String,
        option: String,
        pageable: Pageable
    ): Page<BookResponse>


}