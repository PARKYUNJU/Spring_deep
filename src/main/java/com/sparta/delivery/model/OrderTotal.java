package com.sparta.delivery.model;

//**************최종 주문서*************//

import com.sparta.delivery.dto.OrderTotalDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class OrderTotal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String restaurantName;

    @Column(nullable = false)
    private int totalPrice;

    @Column(nullable = false)
    private int deliveryFee;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "orders_id")
    private List<OrderRequest> menus;

    public OrderTotal(String restaurantName, List<OrderRequest> menus, int deliveryFee, int totalPrice)
    {
        this.restaurantName=restaurantName;
        this.totalPrice=totalPrice;
        this.deliveryFee=deliveryFee;
        this.menus=menus;

    }

}
