package com.example.unittests

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
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