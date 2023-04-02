package com.devbugman.kotest

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe

class BehaviorSpecTest : BehaviorSpec({
    given("a와 b가 주어질때 ") {
        val a = 2
        val b = 3
        val calculator = Calculator()

        `when`("a와 b를 더하면") {
            val result = calculator.sum(a, b)

            then("5가 된다") {
                result shouldBe 5
            }

            then("6보다 작다") {
                result.should { it < 6 }
            }
        }
    }
})