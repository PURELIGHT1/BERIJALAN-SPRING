package com.techno.springbootdasar.domain.dto.response

import java.util.UUID

data class ResMotorDto(
    val id: UUID,
    val nama: String,
    val merk: String
)
