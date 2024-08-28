package com.project.myserver.auth.port.output

import com.project.myserver.auth.persistence.TokenEntity
import org.springframework.data.jpa.repository.JpaRepository

interface TokenJpaRepository : JpaRepository<TokenEntity, Long>