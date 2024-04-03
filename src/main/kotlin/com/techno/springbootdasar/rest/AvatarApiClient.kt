package com.techno.springbootdasar.rest

import com.techno.springbootdasar.domain.dto.response.ResAvatarDto
import com.techno.springbootdasar.domain.dto.response.ResRandomImageDogDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.core.io.Resource
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(value = "AVATAR-API", url = "\${uri.api-client.avatar}")
interface AvatarApiClient {
    @GetMapping("svg")
    fun getImage(
        @RequestParam seed : String
    ): String
}