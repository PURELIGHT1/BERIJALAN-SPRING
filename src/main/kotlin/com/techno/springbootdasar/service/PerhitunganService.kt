package com.techno.springbootdasar.service

import com.techno.springbootdasar.domain.dto.request.ReqPerhitunganDto
import com.techno.springbootdasar.domain.dto.response.ResHasilDto

interface PerhitunganService {
    fun Tambah(data : ReqPerhitunganDto): ResHasilDto
    fun Kurang(data : ReqPerhitunganDto): ResHasilDto
    fun Kali(data : ReqPerhitunganDto): ResHasilDto
    fun Bagi(data : ReqPerhitunganDto): ResHasilDto
}