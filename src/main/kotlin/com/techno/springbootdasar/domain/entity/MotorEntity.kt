package com.techno.springbootdasar.domain.entity

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "mst_motor")
data class MotorEntity(

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID?=null,
    @Column(name = "name")
    var name: String?=null,
    @Column(name = "merk")
    var merk: String?=null,

    )
