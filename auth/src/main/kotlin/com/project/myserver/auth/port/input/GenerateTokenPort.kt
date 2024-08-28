package com.project.myserver.auth.port.input

import com.project.myserver.auth.domain.TokenRequest
import com.project.myserver.auth.domain.TokenResponse

interface GenerateTokenPort {
    fun generateToken(tokenRequest: TokenRequest): TokenResponse
}