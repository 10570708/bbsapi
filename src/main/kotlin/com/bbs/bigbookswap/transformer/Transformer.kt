package com.bbs.bigbookswap.transformer

interface Transformer<A, B> {
    fun transform(source: A): B
}