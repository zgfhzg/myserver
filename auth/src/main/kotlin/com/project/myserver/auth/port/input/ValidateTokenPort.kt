package com.project.myserver.auth.port.input

import com.project.myserver.auth.domain.TokenRequest

interface ValidateTokenPort {
    fun validateToken(tokenRequest: TokenRequest): Boolean
}