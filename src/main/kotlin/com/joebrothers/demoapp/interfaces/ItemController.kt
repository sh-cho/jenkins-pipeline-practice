package com.joebrothers.demoapp.interfaces

import com.joebrothers.demoapp.application.ItemService
import com.joebrothers.demoapp.domain.item.Item
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/items")
class ItemController(
    private val itemService: ItemService,
) {

    @GetMapping("/random")
    fun random(): Item {
        return itemService.getOneRandomly()
    }
}
