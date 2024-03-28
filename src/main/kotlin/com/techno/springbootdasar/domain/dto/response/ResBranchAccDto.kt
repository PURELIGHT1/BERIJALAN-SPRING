package com.techno.springbootdasar.domain.dto.response

import com.fasterxml.jackson.annotation.JsonProperty

data class ResBranchAccDto(
    @JsonProperty("OUT_DATA")
    val Data: List<ResACCApiDto>
)
