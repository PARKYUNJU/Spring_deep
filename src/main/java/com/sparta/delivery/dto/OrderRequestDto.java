package com.sparta.delivery.dto;

import com.sparta.delivery.model.OrderRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDto {
   private Long id; //메뉴id
   private int quantity;

   //1주문: 1메뉴+1수량
}