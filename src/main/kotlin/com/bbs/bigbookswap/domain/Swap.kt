// Written By: Lisa Daly (StudentID: 10570708) - DBS 2022 Final Project B8IT131_2122_TME2 //
// Definition of Data Class : Swap


package com.bbs.bigbookswap.domain

import java.util.*
import javax.persistence.*

@Entity
data class Swap
    (
    @Id
    @SequenceGenerator(name = SWAP_SEQUENCE, sequenceName = SWAP_SEQUENCE, initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SWAP_SEQUENCE)
    val id: Long,
    var type: String,

    var offerOwnerId: Long,
    var offerBookId: Long,
    var offerTitle: String,
    var offerAuthor: String,
    var offerCover: String,

    var recipientOwnerId: Long,
    var recipientBookId: Long,
    var recipientTitle: String,
    var recipientAuthor: String,
    var recipientCover: String,

    var createdDate: Date,
    var swapDate: Date,
    var status: String

) {

    companion object {

        const val SWAP_SEQUENCE: String = "SWAP_SEQUENCE"
    }

}