package com.techno.springbootdasar

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients(basePackages = ["com.techno.springbootdasar.rest"])
class SpringBootDasarApplication

fun main(args: Array<String>) {
	runApplication<SpringBootDasarApplication>(*args)
}
