package com.bbs.bigbookswap.dao

import com.bbs.bigbookswap.domain.Book
import com.bbs.bigbookswap.dto.BookResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookDao: JpaRepository<Book, Long> {

//    @Query(value = "SELECT  FROM BOOKS  WHERE author like %:author% ORDER BY author")
//    @Query("SELECT e FROM BOOKS e WHERE e.author =:id ")
    fun findAllByAuthorIgnoreCaseContainsOrTitleIgnoreCaseContains(author: String, title: String,pageable: Pageable): Page<BookResponse>
    fun findAllByOwnerId(id: Long, pageable: Pageable): Page<BookResponse>
    fun findByOwnerIdNot(id: Long, pageable: Pageable): Page<BookResponse>

    fun findAllByAuthorIgnoreCaseContainsOrTitleIgnoreCaseContainsAndConditionIgnoreCase(author: String, title: String, condition: String,  pageable: Pageable): Page<BookResponse>
    fun findAllByAuthorIgnoreCaseContainsOrTitleIgnoreCaseContainsAndOptionIgnoreCase(author: String, title: String, option: String,  pageable: Pageable): Page<BookResponse>
    fun findAllByConditionIgnoreCaseAndOptionIgnoreCase(option: String,  condition: String, pageable: Pageable): Page<BookResponse>


    fun findAllByOwnerIdAndConditionIgnoreCaseAndOptionIgnoreCase(id: Long, condition: String, option: String, pageable: Pageable): Page<BookResponse>
    fun findAllByAuthorIgnoreCaseContainsOrTitleIgnoreCaseContainsAndConditionIgnoreCaseAndOptionIgnoreCase(author: String, title: String, condition: String, option: String, pageable: Pageable): Page<BookResponse>

    fun findAllByConditionIgnoreCase(condition: String, pageable: Pageable): Page<BookResponse>
    fun findAllByStatus(status: String): List<Book>
    fun findAllByOptionIgnoreCase(option: String, pageable: Pageable): Page<BookResponse>
    fun findAllByAuthorContainsOrTitleContainsAndStatusIs(author:String, title:String,status:String)


}