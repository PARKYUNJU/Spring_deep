package com.sparta.delivery.controller;

import com.sparta.delivery.model.Market;
import com.sparta.delivery.repository.MarketRepository;
import com.sparta.delivery.service.MarketService;
import com.sparta.delivery.dto.MarketDto;
import jdk.javadoc.internal.doclets.formats.html.Contents;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController//***RestController를 꼭꼭 기본생성자 밑에 써주기!!!!!! 안그럼 에러남
public class MarketController {

    private final MarketService marketService;
    private final MarketRepository marketRepository;


    //식당 조회
    @GetMapping("/markets")
    public List<Market> getMarket() {
        return marketRepository.findAllByOrderByModifiedAtDesc();
    }


    //식당 등록
    @PostMapping("/market/register")
    public Market createMarket(@RequestBody MarketDto requestdto)
    {
        Market market=new Market(requestdto);
        return marketService.createMarket(requestdto);

    }
}
