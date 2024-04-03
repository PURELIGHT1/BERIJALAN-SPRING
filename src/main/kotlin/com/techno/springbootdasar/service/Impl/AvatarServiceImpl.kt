package com.techno.springbootdasar.service.Impl

import com.techno.springbootdasar.domain.dto.response.ResAvatarDto
import com.techno.springbootdasar.rest.AvatarApiClient
import com.techno.springbootdasar.service.AvatarService
import org.springframework.core.io.Resource
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class AvatarServiceImpl(
    val apiClient: AvatarApiClient
): AvatarService {
    override fun GetAvatar(seed: String): String {
//        val response = apiClient.getImage(seed)
//        val inputStream = response.body!!.inputStream
//        return inputStream.readAllBytes()

        return apiClient.getImage(seed)
    }
}