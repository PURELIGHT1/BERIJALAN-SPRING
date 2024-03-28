package com.techno.springbootdasar.domain.dto.response

import com.fasterxml.jackson.annotation.JsonProperty

data class ResRandomImageDogDto(
    @JsonProperty("message")
    val image : String,
//    @JsonProperty("status")
//    val status: String
)
