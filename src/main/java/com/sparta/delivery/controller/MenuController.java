package com.sparta.delivery.controller;


import com.sparta.delivery.dto.MenuDto;
import com.sparta.delivery.model.Menu;
import com.sparta.delivery.model.Restaurant;
import com.sparta.delivery.repository.MenuRepository;
import com.sparta.delivery.repository.RestaurantRepository;
import com.sparta.delivery.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MenuController {

    private final MenuRepository menuRepository;
    private final RestaurantRepository restaurantRepository;
    private final MenuService menuService;
    @GetMapping("/restaurant/{marketId}/menus")
    public List<Menu> getReply(@PathVariable Long marketId) {
        return menuService.getMenu(marketId);
    }


    @PostMapping("/restaurant/{marketId}/menu/register")
    public void createMenu(@PathVariable Long marketId,@RequestBody List<MenuDto> requestDtolist)
    {

        menuService.createMenu(requestDtolist,marketId);
    }


}