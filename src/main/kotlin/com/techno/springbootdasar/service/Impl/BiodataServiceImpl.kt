package com.techno.springbootdasar.service.Impl

import com.techno.springbootdasar.domain.dto.request.ReqCreateBiodataDto
import com.techno.springbootdasar.domain.dto.response.ResBiodataDto
import com.techno.springbootdasar.service.BiodataService
import org.springframework.stereotype.Service

@Service
class BiodataServiceImpl : BiodataService{
    override fun getBiodata(data: ReqCreateBiodataDto): ResBiodataDto {
        val response = ResBiodataDto(
            firstName = data.firstName,
            lastName = data.lastName
        )

        return response
    }
}