package com.sparta.delivery.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

//

@Getter //getUsername 이나 getContents 자동 생성
@RequiredArgsConstructor
public class RestaurantDto {

    private String name;
    private int minOrderPrice;
    private int deliveryFee;

}