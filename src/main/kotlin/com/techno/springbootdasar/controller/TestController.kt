package com.techno.springbootdasar.controller

import com.techno.springbootdasar.domain.dto.request.ReqCreateBiodataDto
import com.techno.springbootdasar.domain.dto.request.ReqNumberDto
import com.techno.springbootdasar.domain.dto.response.ResBiodataDto
import com.techno.springbootdasar.service.BiodataService
import com.techno.springbootdasar.service.LogicService
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/api")
class TestController (
    @Value("\${name.lastName}")
    private val firstName: String,

    @Value("\${name.firstName}")
    private val lastName: String,

    private val logicService: LogicService,
    private val service: BiodataService
) {


//    @GetMapping("/test")
//    fun testGetMapping(): ResponseEntity<LinkedHashMap<String, String>>{
//        val response : LinkedHashMap<String, String> = LinkedHashMap()
//        response["first_name"] = firstName
//        response["last_name"] = lastName
//
//        return ResponseEntity.ok().body(response)
//    }
    @GetMapping("/test")
    fun testGetMapping(): ResponseEntity<ResBiodataDto>{
        val response = ResBiodataDto(
            firstName = firstName,
            lastName =  lastName
        )

        return ResponseEntity.ok().body(response)
    }

    @GetMapping("/user")
    fun getName(@RequestParam("age") age : String): ResponseEntity<Any>{
        val response : LinkedHashMap<String, String> = LinkedHashMap()
        response["first_name"] = firstName
        response["last_name"] = lastName
        response["age"] = age

        return ResponseEntity.ok().body(response)
    }

    @GetMapping("/user/{role}")
    fun getUser(@PathVariable("role") role : String): ResponseEntity<Any>{
        val response : LinkedHashMap<String, String> = LinkedHashMap()
        response["first_name"] = firstName
        response["last_name"] = lastName
        response["role"] = role

        return ResponseEntity.ok().body(response)
    }

    @PostMapping("/OddsOrEvent")
    fun getOddsOrEvent(@RequestBody request: ReqNumberDto) : ResponseEntity<Any>{
        val response : LinkedHashMap<String, String> = LinkedHashMap()
        response["result"] = logicService.oddsOrEvent(request.number)

        return ResponseEntity.ok().body(response)
    }

    @PostMapping("/test")
    fun addUserBio(@RequestBody request: ReqCreateBiodataDto) : ResponseEntity<ResBiodataDto>{
        val response = service.getBiodata(request)

        return ResponseEntity.ok().body(response)
    }
}