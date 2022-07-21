package com.sparta.delivery.model;

//************주문 1개(1메뉴) 요청서*****************//
//***********식당id, menu리스트(메뉴id,수량**************//

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class OrderRequest{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //주문id

    @ManyToOne(cascade = CascadeType.ALL)
    private Menu menu; //메뉴판느낌, 각 메뉴id 필요

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private Long menuid;

    @Column(nullable = false)
    private Long marketid;
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;


    public OrderRequest(String name,int price,int quantity,Long menuid,Long marketid)
    {
        this.menuid=menuid;
        this.name=name;
        this.price=price;
        this.quantity=quantity;
        this.marketid=marketid;
    }

    public OrderRequest(List<OrderRequest> orderRequest) {
    }
}

