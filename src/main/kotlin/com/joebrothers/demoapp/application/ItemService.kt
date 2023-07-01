package com.joebrothers.demoapp.application

import com.joebrothers.demoapp.domain.item.Item
import com.joebrothers.demoapp.domain.item.ItemRepository
import org.springframework.stereotype.Service

@Service
class ItemService(
    private val itemRepository: ItemRepository,
) {

    fun getOneRandomly(): Item {
        return itemRepository.getOneRandomly()
    }
}