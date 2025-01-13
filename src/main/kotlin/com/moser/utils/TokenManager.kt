package com.moser.utils

import com.moser.models.*
import java.util.Date
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.JWT


class TokenManager {
    val expirationDate = System.currentTimeMillis() + validityInMs

    fun generateJWTToken(user: User): String {
        val token = JWT.create()
            .withAudience(myAudience)
            .withIssuer(myIssuer)
            .withClaim("username", user.username)
            .withClaim("id_user", user.id_user)
            .withExpiresAt(Date(expirationDate))
            .sign(algorithme)
        return token
    }

    fun verifyJWTToken(): JWTVerifier {
        return JWT.require(Algorithm.HMAC256(mySecret))
            .withAudience(myAudience)
            .withIssuer(myIssuer)
            .build()
    }
}