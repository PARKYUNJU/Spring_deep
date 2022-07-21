package com.sparta.delivery.controller;

import com.sparta.delivery.model.Restaurant;
import com.sparta.delivery.repository.RestaurantRepository;
import com.sparta.delivery.service.RestaurantService;
import com.sparta.delivery.dto.RestaurantDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController//***RestController를 꼭꼭 기본생성자 밑에 써주기!!!!!! 안그럼 에러남
public class RestaurantController {

    private final RestaurantService restaurantService;
    private final RestaurantRepository restaurantRepository;


    //식당 조회
    @GetMapping("/restaurants")
    public List<Restaurant> getMarket() {
        return restaurantRepository.findAllByOrderByModifiedAtDesc();
    }


    //식당 등록
    @PostMapping("/restaurant/register")
    public Restaurant createMarket(@RequestBody RestaurantDto requestdto)
    {
        Restaurant restaurant =new Restaurant(requestdto);
        return restaurantService.createMarket(requestdto);

    }
}
