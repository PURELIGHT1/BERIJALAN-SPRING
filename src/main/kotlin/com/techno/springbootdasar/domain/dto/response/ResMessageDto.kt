package com.techno.springbootdasar.domain.dto.response

import com.fasterxml.jackson.annotation.JsonInclude

data class ResMessageDto<T>(
    val status: Int = 200,
    val message: String = "Success",
    @JsonInclude(JsonInclude.Include.NON_NULL)
    var data: T?=null
)
