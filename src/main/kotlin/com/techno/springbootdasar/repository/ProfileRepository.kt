package com.techno.springbootdasar.repository

import com.techno.springbootdasar.domain.entity.ProfilEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ProfileRepository : JpaRepository<ProfilEntity, UUID> {
//    @Query("SELECT e FROM ProfilEntity")
//    fun findByUsername(username: String): ProfilEntity
    fun findByUsernameAndPassword(username: String?, password: String?): List<ProfilEntity?>
}