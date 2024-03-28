package com.techno.springbootdasar.service

import com.techno.springbootdasar.domain.dto.request.ReqCreateBiodataDto
import com.techno.springbootdasar.domain.dto.response.ResBiodataDto

interface BiodataService {
    fun getBiodata(data: ReqCreateBiodataDto):ResBiodataDto
}