package com.techno.springbootdasar.config

import com.techno.springbootdasar.service.LogicService
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class ContohConfig (
    private val logicService: LogicService
) {
    @Bean
    fun printName(){
        println("Name : Bram Majaya")
    }

    @Bean
    fun getOddsOrEven(){
        val result = logicService.oddsOrEvent(5)
        println("Number result is $result")
    }
}
