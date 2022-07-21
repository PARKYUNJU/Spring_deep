package com.sparta.delivery.repository;

import com.sparta.delivery.model.OrderRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sparta.delivery.repository.MenuRepository;

import java.util.List;

@Repository
public interface OrderRequestRepository extends JpaRepository<OrderRequest, Long> {

    //OrderRequest : 메뉴id,수량
    List<OrderRequest> findAll();

    //전부 찾아줘, 정렬해서, 수정된 날짜 기준으로, 최신순으로(내림차순)
    //공식문서 참고
    //ModifiedAt은 timestamped 안에 있음



}
