package com.sparta.delivery.service;


import com.sparta.delivery.dto.MenuDto;
import com.sparta.delivery.model.Menu;
import com.sparta.delivery.model.Restaurant;
import com.sparta.delivery.repository.MenuRepository;
import com.sparta.delivery.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;


@RequiredArgsConstructor
@Service
public class MenuService {
    private final MenuRepository menuRepository;
    private final RestaurantRepository restaurantRepository;

    // 메뉴 조회
    //되던거
    public List<Menu> getMenu(Long marketId) {
        return menuRepository.findAllByMarketid(marketId);
    }

    //메뉴 생성
    @Transactional
    public void createMenu(List<MenuDto> requestDtolist,Long marketId)
    {
        Restaurant restaurant= restaurantRepository.findById(marketId)
            .orElseThrow(() -> new NullPointerException("존재하지 않는 음식점입니다"));
        for (MenuDto requestDto  : requestDtolist) {
            String name = requestDto.getName();
            int price = requestDto.getPrice();

            isPresentMenu(name, marketId);

            //중복되는 메뉴 없으면 음식 등록
            Menu menu=new Menu(requestDto,marketId);

            menuRepository.save(menu);

        }

    }

    public void isPresentMenu(String name,Long restaurantId){
        List<Menu> menuList = getMenu(restaurantId);

        for (Menu menu:menuList) {
            if (menu.getName().equals(name)) {
                throw new IllegalArgumentException("중복된 메뉴입니다.");
            }
        }
    }

}