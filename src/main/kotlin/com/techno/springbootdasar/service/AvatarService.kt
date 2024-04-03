package com.techno.springbootdasar.service

import com.techno.springbootdasar.domain.dto.response.ResAvatarDto
import org.springframework.core.io.Resource
import org.springframework.http.ResponseEntity

interface AvatarService {
    fun GetAvatar(seed: String): String
}