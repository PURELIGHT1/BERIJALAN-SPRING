package com.techno.springbootdasar.domain.dto.response

import com.fasterxml.jackson.annotation.JsonProperty

data class ResDogListDto(
    @JsonProperty("message")
    val image : Map<String, List<String>>,
    @JsonProperty("status")
    val status: String
)
