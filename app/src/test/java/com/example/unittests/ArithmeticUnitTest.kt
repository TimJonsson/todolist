package com.example.unittests

import org.junit.Test

import org.junit.Assert.*

class ArithmeticUnitTest {
    @Test
    fun additionIsCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun multiplicationIsCorrect() {
        assertEquals(6, 2 * 3)
    }
}