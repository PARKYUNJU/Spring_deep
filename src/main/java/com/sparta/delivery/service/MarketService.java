package com.sparta.delivery.service;

import com.sparta.delivery.dto.MarketDto;
import com.sparta.delivery.model.Market;
import com.sparta.delivery.repository.MarketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@RequiredArgsConstructor
@Service
public class MarketService {
    private final MarketRepository marketRepository;


    //음식점 등록
   /* public void createMarket(MarketDto requestDto)
    {
        String name=requestDto.getName();
        String minOrderPrice= requestDto.getMinOrderPrice();
        String deliveryFee= requestDto.getDeliveryFee();

        if(Integer.parseInt(minOrderPrice)>1000000||Integer.parseInt(minOrderPrice)<1000)
            throw new IllegalArgumentException("1000원~1000,000원 사이를 입력해주세요.");
        if(Integer.parseInt(minOrderPrice)%100!=0)
            throw new IllegalArgumentException("100원 단위로 입력해주세요.");
        if(Integer.parseInt(deliveryFee)>10000)
            throw new IllegalArgumentException("10,000원 이하로 입력해주세요.");
        if(Integer.parseInt(deliveryFee)%500!=0)
            throw new IllegalArgumentException("500원 단위로 입력해주세요");

        Market market=new Market(requestDto);
        marketRepository.save(market);

    }*/
}
