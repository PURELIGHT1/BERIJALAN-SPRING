package com.techno.springbootdasar.domain.dto.request

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

data class ReqCreateBiodataDto(
//    @JsonProperty("firstName")
    val firstName: String,
//    @JsonProperty("lastName")
    val lastName: String,
//    @JsonProperty("alamat")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    val alamat : String? = null
)
