package com.sparta.delivery.repository;
import com.sparta.delivery.model.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MarketRepository extends JpaRepository<Market, Long> {

    List<Market> findAllByOrderByModifiedAtDesc();

    //전부 찾아줘, 정렬해서, 수정된 날짜 기준으로, 최신순으로(내림차순)
    //공식문서 참고
    //ModifiedAt은 timestamped 안에 있음



}
