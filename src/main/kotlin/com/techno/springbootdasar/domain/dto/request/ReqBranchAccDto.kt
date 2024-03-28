package com.techno.springbootdasar.domain.dto.request

import com.fasterxml.jackson.annotation.JsonProperty

data class ReqBranchAccDto(
    @JsonProperty("doGetBranch")
    val doGetBranch: ReqBranchDto,
)
