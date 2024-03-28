package com.techno.springbootdasar.controller

import com.techno.springbootdasar.domain.dto.request.ReqCRUDDto
import com.techno.springbootdasar.domain.dto.request.ReqProfileDto
import com.techno.springbootdasar.domain.dto.response.ResMessageDto
import com.techno.springbootdasar.domain.dto.response.ResMotorDto
import com.techno.springbootdasar.domain.dto.response.ResProfileDto
import com.techno.springbootdasar.service.ProfileService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/v1/api/profile")
class ProfileController(
    val service : ProfileService
) {
    @PostMapping
    fun insert(@Valid @RequestBody req : ReqProfileDto) : ResponseEntity<ResMessageDto<String>> {


        return ResponseEntity.ok().body(service.insert(req))
    }


    @PutMapping
    fun update(
        @RequestParam id: UUID,
        @RequestBody req : ReqProfileDto
    ) : ResponseEntity<ResMessageDto<String>> {
        return ResponseEntity.ok().body(service.update(id,req))
    }

    @GetMapping("/detail")
    fun detail(
        @RequestParam id: UUID
    ) : ResponseEntity<ResMessageDto<ResProfileDto>> {
        return ResponseEntity.ok().body(service.detail(id))
    }

    @GetMapping
    fun list() : ResponseEntity<ResMessageDto<List<ResProfileDto>>> {
        return ResponseEntity.ok().body(service.list())
    }

    @DeleteMapping
    fun delete(
        @RequestParam id : UUID
    ) : ResponseEntity<ResMessageDto<String>> {
        return ResponseEntity.ok().body(service.delete(id))
    }
}