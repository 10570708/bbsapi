package com.bbs.bigbookswap.domain

import java.util.Date
import javax.persistence.*

@Entity
data class BBSUser
    (
    @Id
    @SequenceGenerator(name= USER_SEQUENCE, sequenceName = USER_SEQUENCE, initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator=USER_SEQUENCE)
    val id:Long,

    @Column(unique = true, nullable = false)
    val username:String = "",

    @Column
    val password:String = "",


    var lastLogin: Date = Date(),
    var avatar: String = "dog",
    var numBooks: Long = 0,
    var numSwaps: Long = 0,
    var numDonations: Long = 0) {

    companion object {

        const val USER_SEQUENCE: String = "USER_SEQUENCE"
    }

    fun comparePasswords(passwordIn: String, password: String): Boolean{
        return password ==  passwordIn
    }

}