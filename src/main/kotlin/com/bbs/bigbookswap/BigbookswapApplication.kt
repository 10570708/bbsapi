package com.bbs.bigbookswap

import com.bbs.bigbookswap.domain.BBSUser
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
class BigbookswapApplication{

	@GetMapping
	fun hi():BBSUser {
		return BBSUser(username = "LisaDaly", id=2)
	}
}

fun main(args: Array<String>) {
	runApplication<BigbookswapApplication>(*args)
}

