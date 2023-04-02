package com.devbugman.kotest

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class AnnotationSpecTest : AnnotationSpec() {

    @Test
    fun `1+1는2`() {
        val sut = Calculator()

        val result = sut.sum(1, 1)

        result shouldBe 2
        result.shouldBe(2)
    }
}