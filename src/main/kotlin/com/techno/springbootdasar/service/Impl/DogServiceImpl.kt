package com.techno.springbootdasar.service.Impl

import com.techno.springbootdasar.domain.dto.response.ResDogListDto
import com.techno.springbootdasar.domain.dto.response.ResRandomImageDogDto
import com.techno.springbootdasar.rest.DogApiClient
import com.techno.springbootdasar.service.DogService
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class DogServiceImpl(
    private val apiClient: DogApiClient,
    val restTemplate: RestTemplate = RestTemplateBuilder().build()
) : DogService {
    @Value("\${uri.api-client.dog}")
    val URI: String? = null
    override fun getDogImage(): ResRandomImageDogDto {
        return apiClient.getRandomImage()
    }

    override fun getDogList(): ResDogListDto? {
        val response: ResDogListDto? = restTemplate.getForObject(
            URI+"list/all",
            ResDogListDto::class.java
        )

        return response?.let {
            ResDogListDto(it.image, it.status)
        }
    }
}