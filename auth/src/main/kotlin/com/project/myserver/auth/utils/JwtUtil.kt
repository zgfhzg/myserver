package com.project.myserver.auth.utils

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import java.util.*

object JwtUtil {
    private const val secret: String = "my_secret"

    fun generateToken(username: String, claims: Map<String, Any>, duration: Long): String {
        return Jwts.builder()
            .setClaims(claims)
            .setSubject(username)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + duration))
            .signWith(SignatureAlgorithm.HS512, secret)
            .compact()
    }

    fun validateToken(token: String, username: String): Boolean {
        val claims = getClaimsFromToken(token)
        val tokenUsername = claims.subject
        val expirationDate = claims.expiration
        return (username == tokenUsername && !expirationDate.before(Date()))
    }

    private fun getClaimsFromToken(token: String): Claims {
        return Jwts.parser()
            .setSigningKey(secret)
            .parseClaimsJws(token)
            .body
    }
}