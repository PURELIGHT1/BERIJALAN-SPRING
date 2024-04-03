package com.techno.springbootdasar.controller

import com.techno.springbootdasar.domain.dto.request.ReqDecodeJWTDto
import com.techno.springbootdasar.domain.dto.request.ReqEncodeJWTDto
import com.techno.springbootdasar.domain.dto.request.ReqLoginJWTDto
import com.techno.springbootdasar.domain.dto.response.*
import com.techno.springbootdasar.service.ProfileService
import com.techno.springbootdasar.utils.JWTGenerator
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/v1/api")
class ExampleController(
    val service : ProfileService
) {

    @PostMapping("/encode")
    fun encodeJWT(@RequestBody request: ReqEncodeJWTDto): ResponseEntity<ResMessageDto <ResEncodeJWTDto>>{
        val token = JWTGenerator().createJWT(request)
        return ResponseEntity.ok().body(
            ResMessageDto(
                message = "Success Get Token JWT",
                data = ResEncodeJWTDto(request.id, token)
            )
        )
    }

    @PostMapping("/login")
    fun encodeLoginJWT(@RequestBody request: ReqLoginJWTDto): ResponseEntity<ResMessageDto <ResEncodeLoginDto>>{
        val data = service.login(request)
        val token = JWTGenerator().createLoginJWT(data)
        return ResponseEntity.ok().body(
            ResMessageDto(
                message = "Success Get Token JWT",
                data = data.id?.let { ResEncodeLoginDto(it, token) }
            )
        )
    }

    @GetMapping("/validatelogin")
    fun decodeLoginJWT(@RequestHeader("token") key : String): ResponseEntity<ResMessageDto <ResLoginJWTDto>>{
        val claim = JWTGenerator().decodeLoginJWT(key)
        return ResponseEntity.ok().body(
            ResMessageDto(
                message = "Success Decode JWT",
                data = ResLoginJWTDto(
                    claim["id"].toString(),
                    claim["name"].toString(),
                    claim["username"].toString(),
                    claim["email"].toString()
                )
            )
        )
    }

    @PostMapping("/decode")
    fun decodeJWT(@RequestBody request: ReqDecodeJWTDto): ResponseEntity<ResMessageDto <ResDecodeJWTDto>>{
        val claim = JWTGenerator().decodeJWT(request.token)
        return ResponseEntity.ok().body(
            ResMessageDto(
                message = "Success Decode JWT",
                data = ResDecodeJWTDto(
                    claim["id"].toString(),
                    claim["email"].toString(),
                    claim["password"].toString(),
                    claim["role"].toString()
                )
            )
        )
    }
}