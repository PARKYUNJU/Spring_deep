package com.sparta.delivery.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Getter //getUsername 이나 getContents 자동 생성
@NoArgsConstructor
public class MenuDto {

    private String name;
    private int price;

}