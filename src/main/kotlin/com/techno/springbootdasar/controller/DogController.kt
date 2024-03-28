package com.techno.springbootdasar.controller

import com.techno.springbootdasar.domain.dto.response.ResBranchAccDto
import com.techno.springbootdasar.domain.dto.response.ResDogListDto
import com.techno.springbootdasar.domain.dto.response.ResRandomImageDogDto
import com.techno.springbootdasar.service.ACCService
import com.techno.springbootdasar.service.DogService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/v1/api")
class DogController(
    val service: DogService,
    val accService: ACCService
) {
    @GetMapping("/dog/random-image")
    fun getRandomDgImage(): ResRandomImageDogDto{
        return service.getDogImage()
    }

    @GetMapping("/dog/list")
    fun getDogList(): ResDogListDto?{
        return service.getDogList()
    }

    @PostMapping("/branch")
    fun postACCApiClient(
        @RequestParam search: String,
        @RequestParam limit: String
    ): ResBranchAccDto {

        return accService.postBranch(search, limit)
    }
}