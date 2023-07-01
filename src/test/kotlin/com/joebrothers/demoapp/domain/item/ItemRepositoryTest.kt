package com.joebrothers.demoapp.domain.item

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ItemRepositoryTest {

//    @Mock
//    private lateinit var itemRepository: ItemRepository

    @Test
    fun ok() {
        assertTrue(true)
    }

    @Test
    fun xfail() {
        val lst = (1..9).toList()

        assertThrows(IndexOutOfBoundsException::class.java) {
//            val a = lst[111]
            val a = lst[1]
        }
    }
}
