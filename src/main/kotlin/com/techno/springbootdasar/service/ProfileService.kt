package com.techno.springbootdasar.service

import com.techno.springbootdasar.domain.dto.request.ReqCRUDDto
import com.techno.springbootdasar.domain.dto.request.ReqLoginJWTDto
import com.techno.springbootdasar.domain.dto.request.ReqProfileDto
import com.techno.springbootdasar.domain.dto.response.*
import java.util.*

interface ProfileService {
    fun insert(data : ReqProfileDto) : ResMessageDto<String>
    fun update(id: UUID, data: ReqProfileDto): ResMessageDto<String>
    fun detail(id: UUID): ResMessageDto<ResProfileDto>
    fun list(): ResMessageDto<List<ResProfileDto>>
    fun delete(id: UUID): ResMessageDto<String>
    fun login(data: ReqLoginJWTDto): ResLoginJWTDto
}