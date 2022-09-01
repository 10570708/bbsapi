package com.bbs.bigbookswap.service

import io.jsonwebtoken.Jwts
import org.springframework.stereotype.Service

@Service
class AuthValidation(private val userManagmentService: UserManagmentService) {

    fun validateCookie(cookie: String?): Boolean {
        try {
            if (cookie == null) {
                return false
            }

            val body = Jwts.parser().setSigningKey("secret").parseClaimsJws(cookie).body
            val user = this.userManagmentService.findById(body.issuer.toLong())
            return (user?.id !== null)
        } catch (e: Exception) {
            return false
        }


    }
}