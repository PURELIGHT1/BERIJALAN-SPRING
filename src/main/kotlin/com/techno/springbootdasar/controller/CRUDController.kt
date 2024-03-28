package com.techno.springbootdasar.controller

import com.techno.springbootdasar.domain.dto.request.ReqCRUDDto
import com.techno.springbootdasar.domain.dto.response.ResMessageDto
import com.techno.springbootdasar.domain.dto.response.ResMotorDto
import com.techno.springbootdasar.service.CRUDService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/v1/api/crud")
class CRUDController (
    val service : CRUDService
){

    @PostMapping
    fun insert(@Valid @RequestBody req : ReqCRUDDto) : ResponseEntity<ResMessageDto<String>>{


        return ResponseEntity.ok().body(service.insert(req))
    }

    @PostMapping("entityManager")
    fun insertEM(@RequestBody req : ReqCRUDDto) : ResponseEntity<ResMessageDto<String>>{
        return ResponseEntity.ok().body(service.insert(req))
    }

    @PutMapping
    fun update(
        @RequestParam id: UUID,
        @RequestBody req : ReqCRUDDto
    ) : ResponseEntity<ResMessageDto<String>>{
        return ResponseEntity.ok().body(service.update(id,req))
    }

    @GetMapping("/detail")
    fun detail(
        @RequestParam id: UUID
    ) : ResponseEntity<ResMessageDto<ResMotorDto>>{
        return ResponseEntity.ok().body(service.detail(id))
    }

    @GetMapping
    fun list() : ResponseEntity<ResMessageDto<List<ResMotorDto>>>{
        return ResponseEntity.ok().body(service.list())
    }

    @DeleteMapping
    fun delete(
        @RequestParam id : UUID
    ) : ResponseEntity<ResMessageDto<String>>{
        return ResponseEntity.ok().body(service.delete(id))
    }
}