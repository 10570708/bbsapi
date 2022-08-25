package com.bbs.bigbookswap.service

import com.bbs.bigbookswap.dao.BookDao
import com.bbs.bigbookswap.domain.Book
import com.bbs.bigbookswap.dto.*
import com.bbs.bigbookswap.transformer.AddBookRequestTransformer
import com.bbs.bigbookswap.transformer.toBookResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class BookManagementServiceImpl(private val bookDao: BookDao,
                               private val addBookRequestTransformer: AddBookRequestTransformer
)
    : BookManagementService {

    override fun findById(id: Long): BookResponse? = this.findBookbyId(id).toBookResponse()

    //override fun findByAvatar(avatar: String): List<BookResponse> = this.bookDao.findByAvatar(avatar).map(BBSUser::toUserResponse)  ?: emptyList()

    override fun findAll(pageable: Pageable): Page<BookResponse> = this.bookDao.findAll(pageable).map(Book::toBookResponse)

    override fun save(addBookRequest: AddBookRequest): BookResponse {
        return this.saveOrUpdate(
            addBookRequestTransformer.transform(addBookRequest)
        )
            }

    override fun findAllByAuthorContainsOrTitleContains(searchString1: String,searchString2: String,pageable: Pageable) : Page<BookResponse> = this.bookDao.findAllByAuthorIgnoreCaseContainsOrTitleIgnoreCaseContains(searchString1,searchString2,pageable)

    //override fun findAllByAuthorContainsOrTitleContainsAndStatusIs(searchString1: String,searchString2: String,pageable: Pageable) : Page<BookResponse> = this.bookDao.findAllByAuthorIgnoreCaseContainsOrTitleIgnoreCaseContains(searchString1,searchString2,pageable)

    override fun findAllByOwnerConditionOption(owner: Long, condition: String, option: String,pageable: Pageable) : Page<BookResponse> = this.bookDao.findAllByOwnerIdAndConditionIgnoreCaseAndOptionIgnoreCase(owner,condition,option,pageable)

    override fun findAllBySearchConditionOption(search: String, condition: String, option: String,pageable: Pageable) : Page<BookResponse> = this.bookDao.findAllByAuthorIgnoreCaseContainsOrTitleIgnoreCaseContainsAndConditionIgnoreCaseAndOptionIgnoreCase(search, search,condition,option,pageable)

    override fun findAllByOwnerId(owner: Long, pageable: Pageable): Page<BookResponse> = this.bookDao.findAllByOwnerId(owner,pageable)
    override fun findAllByOwnerIdNot(owner: Long, pageable: Pageable): Page<BookResponse> = this.bookDao.findByOwnerIdNot(owner,pageable)

    override fun findAllBySearchCondition(search: String, condition: String,pageable: Pageable) : Page<BookResponse> = this.bookDao.findAllByAuthorIgnoreCaseContainsOrTitleIgnoreCaseContainsAndConditionIgnoreCase(search, search,condition,pageable)
    override fun findAllBySearchOption(search: String, option: String,pageable: Pageable) : Page<BookResponse> = this.bookDao.findAllByAuthorIgnoreCaseContainsOrTitleIgnoreCaseContainsAndOptionIgnoreCase(search, search,option,pageable)
    override fun findAllByConditionOption(condition: String, option: String,pageable: Pageable) : Page<BookResponse> = this.bookDao.findAllByConditionIgnoreCaseAndOptionIgnoreCase(condition,option,pageable)


    override fun findAllByStatus(status: String): List<BookResponse> = this.bookDao.findAllByStatus(status).map(Book::toBookResponse)

    override fun findAllByOption(option: String, pageable: Pageable): Page<BookResponse> = this.bookDao.findAllByOptionIgnoreCase(option, pageable)

    override fun findAllByCondition(condition: String, pageable: Pageable): Page<BookResponse> = this.bookDao.findAllByConditionIgnoreCase(condition, pageable)


    override fun updateBook(addBookRequest: AddBookRequest): BookResponse {
        val book = this.findBookbyId(addBookRequest.id) ?: throw IllegalStateException("${addBookRequest.id} not found")
        return this.saveOrUpdate(book.apply {
            this.author = addBookRequest.author
        })

    }







    override fun delete(id: Long) {
        this.bookDao.deleteById(id)
    }

    private fun findBookbyId(id: Long): Book? = this.bookDao.findByIdOrNull(id)

    private fun saveOrUpdate(book: Book): BookResponse = this.bookDao.save(book).toBookResponse()
}