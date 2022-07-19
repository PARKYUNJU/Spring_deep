package com.sparta.delivery.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

//

@Getter //getUsername 이나 getContents 자동 생성
@RequiredArgsConstructor
public class MarketDto {

    private String name;
    private String minOrderPrice;
    private String deliveryFee;

}