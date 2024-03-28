package com.techno.springbootdasar.service.Impl

import com.techno.springbootdasar.domain.dto.request.ReqProfileDto
import com.techno.springbootdasar.domain.dto.response.ResMessageDto
import com.techno.springbootdasar.domain.dto.response.ResProfileDto
import com.techno.springbootdasar.domain.entity.ProfilEntity
import com.techno.springbootdasar.exception.DataNotFoundException
import com.techno.springbootdasar.repository.ProfileRepository
import com.techno.springbootdasar.service.ProfileService
import jakarta.persistence.EntityManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.stereotype.Service
import java.util.*


@Service
class ProfileServiceImpl(
    val repo : ProfileRepository
) : ProfileService{
    @Autowired
    lateinit var eM: EntityManager
    override fun insert(req: ReqProfileDto): ResMessageDto<String> {
//         val data : ProfilEntity = repo.findByUsername(req.username)

        val insert = ProfilEntity(
            id = UUID.randomUUID(),
            name = req.nama,
            username = req.username,
            email =  req.email,
            password = req.password
        )

        try{
            repo.save(insert)
            return ResMessageDto()
        }catch ( e : DataIntegrityViolationException){
            val message: String = e.rootCause?.message.toString()
                if (message.contains("violates unique constraint")) {
                val violatedField: String = when {
                    insert?.email?.let { message.contains(it) } == true -> "Email"
                    insert?.username?.let { message.contains(it) } == true -> "Username"
                    else -> "Unknown"
                }
                throw DataIntegrityViolationException("$violatedField sudah ada!")
            } else {
                throw e
            }
        }

    }

    private fun extractViolatedField(errorMessage: String, cekField : String, data : String): String {
        return when (cekField) {
            "EMAIL" -> if (errorMessage.contains(data)) "email" else "Unknown"
            "USERNAME" -> if (errorMessage.contains(data)) "username" else "Unknown"
            else -> "Unknown"
        }
    }

    override fun update(id: UUID, req: ReqProfileDto): ResMessageDto<String> {
        val cekID = repo.findById(id)
        if(!cekID.isPresent){
            throw DataNotFoundException("Data tidak ditemukan!")
        }

        cekID.get().name = req.nama
        cekID.get().username = req.username
        cekID.get().email = req.email
        cekID.get().password = req.password

        repo.save(cekID.get())

        return ResMessageDto()
    }

    override fun detail(id: UUID): ResMessageDto<ResProfileDto> {
        val data = repo.findById(id)
        if(!data.isPresent){
            throw DataNotFoundException("Data tidak ditemukan!")
        }

        val response = ResProfileDto(
            id = data.get().id!!,
            nama = data.get().name!!,
            username = data.get().username!!,
            email = data.get().email!!,
            password = data.get().password!!
        )

        return ResMessageDto(data = response)
    }

    override fun list(): ResMessageDto<List<ResProfileDto>> {
        val data = repo.findAll()

        val listData = arrayListOf<ResProfileDto>()

        for(profile in data){
            val response = ResProfileDto(
                id = profile.id!!,
                nama = profile.name!!,
                username = profile.username!!,
                email = profile.email!!,
                password = profile.password!!
            )

            listData.add(response)
        }

        return ResMessageDto(data = listData)
    }

    override fun delete(id: UUID): ResMessageDto<String> {
        val data = repo.findById(id)
        if(!data.isPresent){
            throw DataNotFoundException("Data tidak ditemukan!")
        }
        repo.delete(data.get())
        return ResMessageDto()
    }

}
