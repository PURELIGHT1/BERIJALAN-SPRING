package com.techno.springbootdasar.domain.dto.request

import com.fasterxml.jackson.annotation.JsonProperty

data class ReqBranchDto(
    @JsonProperty("P_SEARCH")
    val P_SEARCH: String,
    @JsonProperty("P_LIMIT")
    val P_LIMIT: String
)
