package com.techno.springbootdasar.domain.dto.response

import java.util.*

data class ResProfileDto(
    val id: UUID,
    val nama: String,
    val username: String,
    val email: String,
    val password: String,
    val avatar: String?
)
