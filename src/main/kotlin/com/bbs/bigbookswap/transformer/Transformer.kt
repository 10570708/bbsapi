// Written By: Lisa Daly (StudentID: 10570708) - DBS 2022 Final Project B8IT131_2122_TME2 //
// Simple Transform Interface - will be implemented by all other classes in package

package com.bbs.bigbookswap.transformer

interface Transformer<A, B> {
    fun transform(source: A): B
}