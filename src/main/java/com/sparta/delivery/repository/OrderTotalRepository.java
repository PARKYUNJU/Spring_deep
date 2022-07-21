package com.sparta.delivery.repository;

import com.sparta.delivery.model.OrderTotal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface OrderTotalRepository extends JpaRepository<OrderTotal,Long> {

    List<OrderTotal> findOrderTotalById(Long orderid);
}
