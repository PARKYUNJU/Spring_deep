package com.sparta.delivery.model;

import com.sparta.delivery.dto.MenuDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class Menu{

    // ID가 자동으로 생성 및 증가합니다.
    //메뉴의 id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //독자적으로 id 증가해야함
    private Long id;

    //가게 id
   /* @Column(nullable = false)
    private Long marketid;*/

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private Long marketid;


    //id 증가문제
    //식당 id랑 메뉴 id가 따로 증가하지 않고 한번에 차례대로 증가함


    public Menu(MenuDto requestDto, Long marketid) {
        this.marketid=marketid;
        this.name=requestDto.getName();
        this.price=requestDto.getPrice();
    }
}
