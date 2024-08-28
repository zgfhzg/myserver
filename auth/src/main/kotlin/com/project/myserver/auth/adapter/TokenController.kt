package com.project.myserver.auth.adapter

import com.project.myserver.auth.domain.TokenRequest
import com.project.myserver.auth.domain.TokenResponse
import com.project.myserver.auth.service.TokenService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/token")
class TokenController(
    private val tokenService: TokenService,
) {
    @PostMapping
    fun createToken(@RequestBody tokenRequest: TokenRequest): ResponseEntity<TokenResponse> {
        return ResponseEntity.ok(tokenService.generateToken(tokenRequest))
    }
}