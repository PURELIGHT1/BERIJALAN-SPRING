package com.techno.springbootdasar.domain.entity

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "mst_profile")
data class ProfilEntity(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID?=null,
    @Column(name = "name")
    var name: String?=null,
    @Column(name = "username", unique = true)
    var username: String?=null,
    @Column(name = "email", unique = true)
    var email: String?=null,
    @Column(name = "password")
    var password: String?=null,
)