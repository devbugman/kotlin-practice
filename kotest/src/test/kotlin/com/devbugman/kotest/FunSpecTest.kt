package com.devbugman.kotest

import io.kotest.core.spec.style.FunSpec
import io.kotest.core.test.TestCase
import io.kotest.matchers.shouldBe

class FunSpecTest : FunSpec({


    context("a 와 b가 주어지면.") {
        val a = 1
        val b = 2
        test("a 와 b를 더하면 3이된다.") {
            val sut = Calculator()

            val result = sut.sum(a, b)

            result shouldBe 3
        }
    }
}) {
    override suspend fun beforeEach(testCase: TestCase) {
        println("go before Test")
    }
}