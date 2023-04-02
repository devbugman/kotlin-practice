package com.devbugman.kotest

import jakarta.validation.Valid
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.CREATED
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test")
class TestController {

    @PostMapping
    @ResponseStatus(CREATED)
    fun test(@RequestBody @Valid request: TestRequest, bindingResult: BindingResult): String {
        if (bindingResult.hasErrors()) {
            throw RuntimeException("exception")
        }
        return "${request.id}의 ${request.name}입니다."
    }
}

data class TestRequest(
    @field:NotNull val id: Long,
    @field:NotBlank val name: String
)