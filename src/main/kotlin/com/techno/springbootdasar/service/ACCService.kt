package com.techno.springbootdasar.service

import com.techno.springbootdasar.domain.dto.response.ResBranchAccDto


interface ACCService {
    fun postBranch(search: String, limit: String): ResBranchAccDto
}