package com.project.myserver.auth.persistence

import jakarta.persistence.*
import lombok.Getter
import lombok.Setter
import java.time.ZonedDateTime

@Entity
@Table(name = "token", schema = "public")
@Getter
@Setter
class TokenEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L

    @Column(name = "access_token")
    var accessToken = ""

    @Column(name = "refresh_token")
    var refreshToken = ""

    @Column(name = "expire_date")
    var expireDate: ZonedDateTime? = null

    @Column(name = "issued_date")
    var issuedDate: ZonedDateTime? = null

    constructor(accessToken: String, refreshToken: String, expireDate: ZonedDateTime, issuedDate: ZonedDateTime) : this() {
        this.accessToken = accessToken
        this.refreshToken = refreshToken
        this.expireDate = expireDate
        this.issuedDate = issuedDate
    }
}