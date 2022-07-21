package com.sparta.delivery.dto;

import com.sparta.delivery.model.OrderRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.criterion.Order;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderTotalDto {
    //최종 주문: 주문 내역서 리스트, 식당id
    private List<OrderRequestDto> menus;
    private Long retaurantid;

}