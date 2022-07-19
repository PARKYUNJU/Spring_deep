package com.sparta.delivery.controller;

import com.sparta.delivery.model.Market;
import com.sparta.delivery.repository.MarketRepository;
import com.sparta.delivery.service.MarketService;
import com.sparta.delivery.dto.MarketDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController//***RestController를 꼭꼭 기본생성자 밑에 써주기!!!!!! 안그럼 에러남
public class MarketController {

    private final MarketService marketService;
    private final MarketRepository marketRepository;


    @GetMapping("/market/markets")
    public List<Market> getMarket() {
        return marketRepository.findAllByOrderByModifiedAtDesc();
    }

    @PostMapping("/market/markets")
    public Market createMarket(@RequestBody MarketDto requestdto)
    {
        Market market=new Market(requestdto);
        return marketRepository.save(market);

    }
}
