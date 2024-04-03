package com.techno.springbootdasar.domain.dto.response

import com.fasterxml.jackson.annotation.JsonProperty

data class ResBranchAccDto(
    @JsonProperty("OUT_STAT")
    val status: String,
    @JsonProperty("OUT_MESS")
    val message: String,
    @JsonProperty("OUT_DATA")
    val data: List<ResACCApiDto>
)
