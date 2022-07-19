package com.sparta.delivery.model;

import com.sparta.delivery.dto.MarketDto;

import com.sparta.delivery.repository.Timestamped;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Market extends Timestamped {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;


    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int minOrderPrice;

    @Column(nullable = false)
    private int deliveryFee;

    public Market(String name,int minOrderPrice,int deliveryFee){
        this.name=name;
        this.minOrderPrice=minOrderPrice;
        this.deliveryFee=deliveryFee;
    }

    public Market(MarketDto requestDto) {
        this.name=requestDto.getName();
        this.minOrderPrice=requestDto.getMinOrderPrice();
        this.deliveryFee=requestDto.getDeliveryFee();
    }



}
