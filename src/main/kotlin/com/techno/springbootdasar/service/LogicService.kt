package com.techno.springbootdasar.service

import org.springframework.stereotype.Service

@Service
class LogicService {
    fun oddsOrEvent(number: Int) : String{
        if(number%2 == 0){
            return  "EVENT"
        }else{
            return "Odds"
        }
    }
}