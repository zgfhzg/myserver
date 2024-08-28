package com.project.myserver.auth.domain

import java.time.ZonedDateTime

data class TokenRequest(
    val accessToken: String,
    val username: String,
    val claims: Map<String, Any>,
)

data class TokenResponse(
    val accessToken: String,
    val refreshToken: String,
    val username: String,
    val expiresDate: ZonedDateTime,
    val issuedDate: ZonedDateTime,
)