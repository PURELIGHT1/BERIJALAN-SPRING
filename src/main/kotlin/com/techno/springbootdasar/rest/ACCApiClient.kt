package com.techno.springbootdasar.rest

import com.techno.springbootdasar.domain.dto.request.ReqBranchAccDto
import com.techno.springbootdasar.domain.dto.response.ResBranchAccDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(value = "ACC-API", url = "\${uri.api-client.acc}")
interface ACCApiClient {
    @PostMapping("getdata/getbranch")
    fun postBranch(
        @RequestBody data: Map<String, Map<String, String>>,
//        @RequestBody data: ReqBranchAccDto,
        @RequestHeader("APIKey") apiKey: String,
        @RequestHeader("X-Content-Type-Options") contentTypeOptions: String,
        @RequestHeader("X-XSS-Protection") xssProtection: String,
        @RequestHeader("Strict-Transport-Security") transportSecurity: String,
        @RequestHeader("X-Frame-Options") frameOptions: String
    ): ResBranchAccDto

}