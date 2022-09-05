// Written By: Lisa Daly (StudentID: 10570708) - DBS 2022 Final Project B8IT131_2122_TME2 //
// Transformer class for AddUserRequest to BBSUser

package com.bbs.bigbookswap.transformer

import com.bbs.bigbookswap.domain.BBSUser
import com.bbs.bigbookswap.dto.AddUserRequest
import org.springframework.stereotype.Component

@Component
class AddUserRequestTransformer : Transformer<AddUserRequest, BBSUser> {

    override fun transform(source: AddUserRequest): BBSUser {
        return BBSUser(
            id = 0,
            username = source.username,
            password = source.password
        )
    }
}