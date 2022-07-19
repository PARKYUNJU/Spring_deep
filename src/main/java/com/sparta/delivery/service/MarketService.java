package com.sparta.delivery.service;

import com.sparta.delivery.dto.MarketDto;
import com.sparta.delivery.model.Market;
import com.sparta.delivery.repository.MarketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class MarketService {
    private final MarketRepository marketRepository;


    //음식점 등록
    public Market createMarket(MarketDto requestDto)
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

        Market market=new Market(name,minOrderPrice,deliveryFee);
        marketRepository.save(market);

        return market;
    }
}
