package com.sparta.delivery.controller;

import com.sparta.delivery.dto.OrderRequestDto;
import com.sparta.delivery.model.OrderTotal;
import com.sparta.delivery.service.OrderRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderRequestService orderRequestService;


    @PostMapping("/order/request")
    public void createorder(@PathVariable Long marketid, @RequestBody List<OrderRequestDto> requestDtolist)
    {
        orderRequestService.createOrder(requestDtolist, marketid);
    }
}
