package com.bbs.bigbookswap.transformer

import com.bbs.bigbookswap.domain.BBSUser
import com.bbs.bigbookswap.dto.AddUserRequest
import org.springframework.stereotype.Component

@Component
class AddUserRequstTransformer : Transformer<AddUserRequest, BBSUser> {

    override fun transform(source: AddUserRequest): BBSUser {
        return BBSUser(
            id = 0,
            username = source.username,
            password = source.password
        )
    }
}