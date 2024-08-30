package com.project.myserver.auth.service

import com.project.myserver.auth.domain.TokenRequest
import com.project.myserver.auth.domain.TokenResponse
import com.project.myserver.auth.persistence.TokenEntity
import com.project.myserver.auth.port.input.GenerateTokenPort
import com.project.myserver.auth.port.input.ValidateTokenPort
import com.project.myserver.auth.port.output.TokenJpaRepository
import com.project.myserver.auth.utils.JwtUtil
import org.springframework.stereotype.Service
import java.time.ZonedDateTime

@Service
class TokenService(
    private val tokenJpaRepository: TokenJpaRepository,
) : GenerateTokenPort, ValidateTokenPort {
    override fun generateToken(tokenRequest: TokenRequest): TokenResponse {
        val accessToken = JwtUtil.generateToken(tokenRequest.username, tokenRequest.claims, 1000 * 60 * 30)
        val refreshToken = JwtUtil.generateToken(tokenRequest.username, tokenRequest.claims, 1000 * 60 * 60)

        // todo: 날짜 데이터 수정 필요
        val tokenEntity = TokenEntity(accessToken, refreshToken, ZonedDateTime.now(), ZonedDateTime.now())
        tokenJpaRepository.save(tokenEntity)

        return TokenResponse(accessToken, refreshToken, tokenRequest.username, ZonedDateTime.now().plusMinutes(30), ZonedDateTime.now().plusHours(1))
    }

    override fun validateToken(tokenRequest: TokenRequest): Boolean {
        return JwtUtil.validateToken(tokenRequest.accessToken)
    }
}
