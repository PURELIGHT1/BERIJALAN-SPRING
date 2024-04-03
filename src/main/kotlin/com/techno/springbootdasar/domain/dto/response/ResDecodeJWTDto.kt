package com.techno.springbootdasar.domain.dto.response

data class ResDecodeJWTDto(
    val id: String,
    val role: String,
    val email: String,
    val password: String
)