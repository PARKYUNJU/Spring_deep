package com.sparta.delivery.service;

import com.sparta.delivery.dto.OrderRequestDto;
import com.sparta.delivery.model.*;
import com.sparta.delivery.repository.MenuRepository;
import com.sparta.delivery.repository.OrderRequestRepository;
import com.sparta.delivery.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderRequestService {

    private final MenuRepository menuRepository;
    private final OrderRequestRepository orderRequestRepository;
    private final RestaurantRepository restaurantRepository;

    //OrderRequest : 어떤메뉴(메뉴id), 얼만큼(quantity)
    //OrderTotal: OrderRequest를 다 합쳐서 최종 주문
    /*public OrderRequest createOrder(OrderRequestDto requestDto, Long menuid)
    {
        Food food=foodRepository.findById(menuid).orElseThrow(() -> new NullPointerException("존재하지 않는 메뉴입니다"));
        //food : 메뉴이름(name),가격(price),식당정보(restaurant)

        int quantity=requestDto.getQuantity();

        if(quantity<1||quantity>100)
        {
            throw new IllegalArgumentException("수량은 1개에서 100개 사이로 입력해주세요");
        }

        OrderRequest orderRequest=new OrderRequest(food,quantity,menuid);
        orderRepository.save(orderRequest);
        return orderRequest;
    }*/

    //requestDto : 메뉴id, 수량
    @Transactional
    public void createOrder(List<OrderRequestDto> requestDtolist, Long marketId)
    {

        Restaurant restaurant= restaurantRepository.findById(marketId)
                .orElseThrow(() -> new NullPointerException("존재하지 않는 음식점입니다"));
        String restaurantName=restaurant.getName();
        int deliveryFee=restaurant.getDeliveryFee();
        int totalPrice=0;

        for (OrderRequestDto requestDto  : requestDtolist) {
            Long menuid=requestDto.getId();
            Menu menu=menuRepository.findMenuById(menuid)
                    .orElseThrow(() -> new NullPointerException("존재하지 않는 메뉴입니다"));;
            String name = menu.getName();
            int price = menu.getPrice();
            int quantity=requestDto.getQuantity();
            if(quantity<1||quantity>100)
            {
                throw new IllegalArgumentException("수량은 1개에서 100개 사이로 입력해주세요");
            }
            totalPrice+=price*quantity;
            OrderRequest orderRequest=new OrderRequest(name,price,quantity,menuid,marketId);
            orderRequestRepository.save(orderRequest);
        }
        List<OrderRequest> orderList = getOrderRequest();
        OrderTotal orderTotal=new OrderTotal(restaurantName,orderList,deliveryFee,totalPrice);

    }


    public List<OrderRequest> getOrderRequest() {
        return orderRequestRepository.findAll();
    }


}
