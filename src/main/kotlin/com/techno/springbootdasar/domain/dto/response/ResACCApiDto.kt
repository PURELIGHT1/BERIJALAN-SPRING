package com.techno.springbootdasar.domain.dto.response

import com.fasterxml.jackson.annotation.JsonProperty

data class ResACCApiDto(
    @JsonProperty("CD_SP")
    val CD_SP: String?,
    @JsonProperty("AREA")
    val AREA: String?
)
