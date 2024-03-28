package com.techno.springbootdasar.service.Impl

import com.techno.springbootdasar.domain.dto.request.ReqCRUDDto
import com.techno.springbootdasar.domain.dto.response.ResMessageDto
import com.techno.springbootdasar.domain.dto.response.ResMotorDto
import com.techno.springbootdasar.domain.entity.MotorEntity
import com.techno.springbootdasar.exception.DataNotFoundException
import com.techno.springbootdasar.repository.MotorRepository
import com.techno.springbootdasar.service.CRUDService
import jakarta.persistence.EntityManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class CRUDServiceImpl(
    val repo : MotorRepository
): CRUDService {
    @Autowired
    lateinit var entityManager: EntityManager
    override fun insert(req: ReqCRUDDto): ResMessageDto<String> {

        val insert = MotorEntity(
            id = UUID.randomUUID(),
            name = req.nama,
            merk = req.merk
        )
        repo.save(insert)

        return ResMessageDto()
    }

    override fun update(id: UUID, req: ReqCRUDDto): ResMessageDto<String> {
        val cekID = repo.findById(id)

        cekID.get().merk = req.merk
        cekID.get().name = req.nama

        repo.save(cekID.get())

        return ResMessageDto()
    }

    override fun detail(id: UUID): ResMessageDto<ResMotorDto> {
        val data = repo.findById(id)
        if(!data.isPresent){
            throw DataNotFoundException("Data tidak ditemukan!")
        }
        val response = ResMotorDto(
            id = data.get().id!!,
            nama = data.get().name!!,
            merk = data.get().merk!!
        )

        return ResMessageDto(data = response)
    }

    override fun list(): ResMessageDto<List<ResMotorDto>> {
        val data = repo.findAll()

        val listData = arrayListOf<ResMotorDto>()

        for(motor in data){
            val response = ResMotorDto(
                id = motor.id!!,
                nama = motor.name!!,
                merk = motor.merk!!
            )

            listData.add(response)
        }

        return ResMessageDto(data = listData)
    }

    override fun delete(id: UUID): ResMessageDto<String> {
        repo.deleteById(id)
        return ResMessageDto()
    }

    override fun insertEntity(req: ReqCRUDDto): ResMessageDto<String> {
        val data = ResMotorDto(
            id = UUID.randomUUID(),
            nama = req.nama,
            merk = req.merk
        )
        entityManager.persist(data)

        return ResMessageDto()
    }
}