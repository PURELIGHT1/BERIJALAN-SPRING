package com.techno.springbootdasar.repository

import com.techno.springbootdasar.domain.entity.ProfilEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface ProfileRepository : JpaRepository<ProfilEntity, UUID> {
    fun findByUsername(username: String): ProfilEntity
}