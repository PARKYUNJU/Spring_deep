package com.sparta.delivery.repository;

import com.sparta.delivery.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

    List<Menu> findAllByMarketid(Long marketId);
    Optional<Menu> findMenuById(Long menuId);
}