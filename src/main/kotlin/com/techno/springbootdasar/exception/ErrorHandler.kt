package com.techno.springbootdasar.exception

import com.techno.springbootdasar.domain.dto.response.ResMessageDto
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.lang.Exception

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
class ErrorHandler {
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleArgumentNotValidException(
        exception: MethodArgumentNotValidException
    ): ResponseEntity<Any>{
        val errors = mutableListOf<String>()
        exception.bindingResult.fieldErrors.forEach{
            errors.add(it.defaultMessage!!)
        }
        val result = mapOf<String, Any>("Status" to "F", "error" to "field", "message" to errors)
        return ResponseEntity.badRequest().body(result)
    }

    @ExceptionHandler(DataNotFoundException::class)
    fun handleDataNotFound(
        exception: RuntimeException
    ): ResponseEntity<ResMessageDto<String>>{
        exception.printStackTrace()
        return ResponseEntity.badRequest().body(
            ResMessageDto(
                status = HttpStatus.NOT_FOUND.value(),
                message = exception.message.toString()
            )
        )
    }

    @ExceptionHandler(DataIntegrityViolationException::class)
    fun handleDataUnique(
        exception: DataIntegrityViolationException
    ): ResponseEntity<ResMessageDto<String>>{
        exception.printStackTrace()
        
        return ResponseEntity.badRequest().body(
            ResMessageDto(
                status = HttpStatus.CONFLICT.value(),
                message = exception.message.toString()
            )
        )
    }

}