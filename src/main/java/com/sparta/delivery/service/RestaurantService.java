package com.sparta.delivery.service;

import com.sparta.delivery.dto.RestaurantDto;
import com.sparta.delivery.model.Restaurant;
import com.sparta.delivery.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;


    //음식점 등록
    public Restaurant createMarket(RestaurantDto requestDto)
    {
        String name=requestDto.getName();
        int minOrderPrice= requestDto.getMinOrderPrice();
        int deliveryFee= requestDto.getDeliveryFee();

        if(minOrderPrice>1000000||minOrderPrice<1000)
            throw new IllegalArgumentException("1000원~1000,000원 사이를 입력해주세요.");
        if(minOrderPrice%100!=0)
            throw new IllegalArgumentException("100원 단위로 입력해주세요.");
        if(deliveryFee>10000)
            throw new IllegalArgumentException("10,000원 이하로 입력해주세요.");
        if(deliveryFee%500!=0)
            throw new IllegalArgumentException("500원 단위로 입력해주세요");

        Restaurant restaurant =new Restaurant(name,minOrderPrice,deliveryFee);
        restaurantRepository.save(restaurant);

        return restaurant;
    }
}
