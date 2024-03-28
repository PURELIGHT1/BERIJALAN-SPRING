package com.techno.springbootdasar.domain.dto.request

import jakarta.validation.constraints.*

data class ReqProfileDto(
    @field:NotNull(message = "Nama tidak boleh kosong")
    @field:NotBlank(message = "Nama tidak boleh string kosong!")
    @field:Size(max = 100, message = "Nama maksimal 100!")
    @field:Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Nama hanya berisi huruf!")
    val nama: String,

    @field:NotNull(message = "Username tidak boleh kosong")
    @field:NotBlank(message = "Username tidak boleh string kosong!")
    @field:Pattern(regexp = "^\\S{2,}$", message = "Username tidak boleh ada spasi!")
    @field:Size(max = 32, message = "Username maksimal 32!")
    //unik
    val username: String,

    @field:NotNull(message = "Email tidak boleh kosong")
    @field:NotBlank(message = "Email tidak boleh string kosong!")
    @field:Email(message = "Email tidak sesuai format!")
    //unik
    val email: String,

    @field:NotNull(message = "Password tidak boleh kosong")
    @field:NotBlank(message = "Password tidak boleh string kosong!")
    @field:Size(max = 32, message = "Username maksimal 32!")
    val password: String
)
