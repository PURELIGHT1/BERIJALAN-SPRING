package com.techno.springbootdasar.domain.dto.request

data class ReqEncodeJWTDto(
    val id: String = "",
    val role: String = "",
    val email: String = "",
    val password: String = ""
)
