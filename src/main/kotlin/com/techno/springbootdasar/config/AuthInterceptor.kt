package com.techno.springbootdasar.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.techno.springbootdasar.domain.dto.response.ResMessageDto
import com.techno.springbootdasar.utils.JWTGenerator
import io.jsonwebtoken.ExpiredJwtException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor

@Component
class AuthInterceptor(
    @Value("\${header.request.api-key}")
    private val apiKey: String
) : HandlerInterceptor {
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
//        val apiKeyRequest = request.getHeader("APIKey")
        val token = request.getHeader("token")

        if(token == null){
            val body: ResMessageDto<String> = ResMessageDto(
                status = 401,
                message = "you don't have permission"
            )
            internalServerError(body, response)
            return false
        }

//        if(apiKeyRequest != apiKey){
//            val body: ResMessageDto<String> = ResMessageDto(
//                status = 403,
//                message = "you don't have permission"
//            )
//            internalServerError(body, response)
//            return false
//        }

        try {
            JWTGenerator().decodeJWT(token).get("id")
        }
        catch (e: ExpiredJwtException){
            e.printStackTrace()
            val body: ResMessageDto<String> = ResMessageDto(401, "Invalid Token")
            internalServerError(body, response)
        }
        return super.preHandle(request, response, handler)
    }

    fun internalServerError(body : ResMessageDto<String>, response: HttpServletResponse): HttpServletResponse{
        response.status = HttpStatus.FORBIDDEN.value()
        response.contentType = "application/json"
        response.writer.write(convertObjectToJson(body))

        return response
    }

    fun convertObjectToJson(dto: ResMessageDto<String>): String {
        return ObjectMapper().writeValueAsString(dto)
    }
}