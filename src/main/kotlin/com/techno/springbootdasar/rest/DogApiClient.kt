package com.techno.springbootdasar.rest

import com.techno.springbootdasar.domain.dto.response.ResRandomImageDogDto
import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(value = "DOG-API", url = "\${uri.api-client.dog}")
interface DogApiClient {
    @GetMapping("/image/random")
    fun getRandomImage(): ResRandomImageDogDto
}