package com.techno.springbootdasar.service.Impl

import com.techno.springbootdasar.domain.dto.request.ReqBranchAccDto
import com.techno.springbootdasar.domain.dto.request.ReqBranchDto
import com.techno.springbootdasar.domain.dto.response.ResACCApiDto
import com.techno.springbootdasar.domain.dto.response.ResBranchAccDto
import com.techno.springbootdasar.rest.ACCApiClient
import com.techno.springbootdasar.service.ACCService
import org.springframework.stereotype.Service

@Service
class ACCServiceImpl(
    private val apiClient: ACCApiClient,
): ACCService {
    override fun postBranch(search: String, limit: String): ResBranchAccDto {
//        val data = ReqBranchDto(
//            P_SEARCH = search,
//            P_LIMIT = limit
//        )
//        val insertData = ReqBranchAccDto(
//            doGetBranch = data
//        )
        val data = mapOf("P_SEARCH" to search, "P_LIMIT" to limit)
        val insertData: Map<String, Map<String, String>> = mapOf("doGetBranch" to data)
        return apiClient.postBranch(
            data = insertData,
            apiKey = "1234567890",
            contentTypeOptions = "nosniff",
            xssProtection = "1; mode=block",
            transportSecurity = "max-age=31536000; includeSubDomains; preload",
            frameOptions = "SAMEORIGIN",
        )

    }
}