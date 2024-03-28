package com.techno.springbootdasar.domain.dto.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class ReqCRUDDto(
    @field:NotEmpty(message = "Name cannot be empty")
    val nama: String,
    @field:NotBlank(message = "Merk cannot be blank")
    val merk: String
)
