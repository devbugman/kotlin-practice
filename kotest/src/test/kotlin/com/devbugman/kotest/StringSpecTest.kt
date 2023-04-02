package com.devbugman.kotest

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringSpecTest : StringSpec({

    "1 + 2 = 3이다" {
        val sut = Calculator()
        val result = sut.sum(1, 2)

        result shouldBe 3
    }

    " 2 * 3 = 6" {
        val sut = Calculator()

        val result = sut.multiply(2, 3)

        result.shouldBe(6)
    }
}) 