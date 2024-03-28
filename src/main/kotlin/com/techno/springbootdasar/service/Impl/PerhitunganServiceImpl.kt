package com.techno.springbootdasar.service.Impl

import com.techno.springbootdasar.domain.dto.request.ReqPerhitunganDto
import com.techno.springbootdasar.domain.dto.response.ResHasilDto
import com.techno.springbootdasar.service.PerhitunganService
import org.springframework.stereotype.Service

@Service
class PerhitunganServiceImpl : PerhitunganService {
    override fun Tambah(data: ReqPerhitunganDto): ResHasilDto {
        val response = ResHasilDto(
            hasil = data.angka1 + data.angka2
        )
        return response
    }

    override fun Kurang(data: ReqPerhitunganDto): ResHasilDto {
        val response = ResHasilDto(
            hasil = data.angka1 - data.angka2
        )
        return response
    }

    override fun Kali(data: ReqPerhitunganDto): ResHasilDto {
        val response = ResHasilDto(
            hasil = data.angka1 * data.angka2
        )
        return response
    }

    override fun Bagi(data: ReqPerhitunganDto): ResHasilDto {
        val response = ResHasilDto(
            hasil = data.angka2 / data.angka1
        )
        return response
    }
}