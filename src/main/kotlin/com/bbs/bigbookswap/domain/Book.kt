// Written By: Lisa Daly (StudentID: 10570708) - DBS 2022 Final Project B8IT131_2122_TME2 //
// Definition of Data Class : Book


package com.bbs.bigbookswap.domain

import java.util.Date
import javax.persistence.*

@Entity
data class Book(
    @Id
    @SequenceGenerator(name = BOOK_SEQUENCE, sequenceName = BOOK_SEQUENCE, initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = BOOK_SEQUENCE)
    val id: Long,
    var ownerId: Long,
    var title: String,
    var author: String,
    var cover: String,
    var publisher: String,
    var numPages: String,
    var addedDate: Date = Date(),
    var status: String,
    var condition: String,
    var isbn: Long,
    var option: String
) {

    companion object {

        const val BOOK_SEQUENCE: String = "BOOK_SEQUENCE"
    }

}