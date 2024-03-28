package com.techno.springbootdasar.service

import com.techno.springbootdasar.domain.dto.request.ReqCRUDDto
import com.techno.springbootdasar.domain.dto.response.ResMessageDto
import com.techno.springbootdasar.domain.dto.response.ResMotorDto
import java.util.UUID

interface CRUDService {
    fun insert(data : ReqCRUDDto) : ResMessageDto<String>
    fun update(id: UUID, data: ReqCRUDDto): ResMessageDto<String>
    fun detail(id: UUID): ResMessageDto<ResMotorDto>
    fun list(): ResMessageDto<List<ResMotorDto>>
    fun delete(id: UUID): ResMessageDto<String>

    fun insertEntity(data : ReqCRUDDto): ResMessageDto<String>
}