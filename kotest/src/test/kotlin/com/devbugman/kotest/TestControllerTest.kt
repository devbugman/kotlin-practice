package com.devbugman.kotest

import com.fasterxml.jackson.databind.ObjectMapper
import io.kotest.core.spec.style.BehaviorSpec
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.TestConstructor
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post

@SpringBootTest
@AutoConfigureMockMvc
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
internal class TestControllerTest(
    private val mockMvc: MockMvc,
    private val objectMapper: ObjectMapper
) : BehaviorSpec({

    given("input이 주어질 경우") {
        val uri = "/test"
        `when`("테스트 request를 등록하면") {
            val request = TestRequest(1L, "name")
            val result = mockMvc.post(uri) {
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(request)
            }.andDo { print() }

            then("상태코드는 CREATED이다") {
                result.andExpect { status { isCreated() } }
            }
        }

        `when`("잘못된 input일 경우 ") {
            val request = TestRequest(1L, " ")

            val result = mockMvc.post(uri) {
                MediaType.APPLICATION_JSON
                objectMapper.writeValueAsString(request)
            }.andDo { print() }

            then("Internal Server Error가 발생한다.") {
                result.andExpect { status { isInternalServerError() } }
            }
        }
    }
})