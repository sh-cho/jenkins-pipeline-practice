package com.joebrothers.demoapp.domain.item

import org.springframework.stereotype.Repository

@Repository
class ItemRepository {

    private val items = (1L..9L).map { Item(it, "item - $it") }

    fun getOneRandomly(): Item {
        return items.random()
    }
}