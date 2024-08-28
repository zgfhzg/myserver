package com.project.myserver.auth.service

import com.project.myserver.auth.domain.TokenRequest
import com.project.myserver.auth.domain.TokenResponse
import com.project.myserver.auth.port.input.GenerateTokenPort
import com.project.myserver.auth.utils.JwtUtil
import org.springframework.stereotype.Service

@Service
class TokenService : GenerateTokenPort {
    override fun generateToken(tokenRequest: TokenRequest): TokenResponse {
        val accessToken = JwtUtil.generateToken(tokenRequest.username, tokenRequest.claims, 1000 * 60 * 30)
        val refreshToken = JwtUtil.generateToken(tokenRequest.username, tokenRequest.claims, 1000 * 60 * 60)

        TODO("refresh token -> db에 저장")
    }
}