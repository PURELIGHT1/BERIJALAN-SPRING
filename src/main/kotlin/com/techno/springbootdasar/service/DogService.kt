package com.techno.springbootdasar.service

import com.techno.springbootdasar.domain.dto.response.ResDogListDto
import com.techno.springbootdasar.domain.dto.response.ResRandomImageDogDto

interface DogService {
    fun getDogImage(): ResRandomImageDogDto

    fun getDogList(): ResDogListDto?
}