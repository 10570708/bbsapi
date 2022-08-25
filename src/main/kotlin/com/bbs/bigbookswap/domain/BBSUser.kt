package com.bbs.bigbookswap.domain

import java.util.Date
import javax.persistence.*

@Entity
data class BBSUser (
    @Id
    @SequenceGenerator(name= USER_SEQUENCE, sequenceName = USER_SEQUENCE, initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator=USER_SEQUENCE)
    val id:Long,
    val username:String = "lDal",
    val password:String = "pass",
    var lastLogin: Date = Date(),
    var avatar: String = "dog",
    var numBooks: Long = 0,
    var numSwaps: Long = 0,
    var numDonations: Long = 0) {

    companion object {

        const val USER_SEQUENCE: String = "USER_SEQUENCE"
    }

}