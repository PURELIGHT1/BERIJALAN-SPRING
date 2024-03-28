package com.techno.springbootdasar.controller

import com.techno.springbootdasar.domain.dto.request.ReqPerhitunganDto
import com.techno.springbootdasar.domain.dto.response.ResHasilDto
import com.techno.springbootdasar.service.PerhitunganService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/api/hitung")
class PerhitunganController(
    private val service : PerhitunganService
) {

    @PostMapping("/tambah")
    fun tambahData(@RequestBody request: ReqPerhitunganDto) : ResponseEntity<ResHasilDto> {
        val response = service.Tambah(request)

        return ResponseEntity.ok().body(response)
    }

    @PostMapping("/kurang")
    fun kurangData(@RequestBody request: ReqPerhitunganDto) : ResponseEntity<ResHasilDto> {
        val response = service.Kurang(request)

        return ResponseEntity.ok().body(response)
    }

    @PostMapping("/kali")
    fun kaliData(@RequestBody request: ReqPerhitunganDto) : ResponseEntity<ResHasilDto> {
        val response = service.Kali(request)

        return ResponseEntity.ok().body(response)
    }

    @PostMapping("/bagi")
    fun bagiData(@RequestBody request: ReqPerhitunganDto) : ResponseEntity<ResHasilDto> {
        val response = service.Bagi(request)

        return ResponseEntity.ok().body(response)
    }
}