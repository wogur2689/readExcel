package com.example.readexcel.service;

import com.example.readexcel.entity.Menu;
import com.example.readexcel.entity.Restaurant;
import com.example.readexcel.repository.MenuRepository;
import com.example.readexcel.repository.RestaurantRepository;
import com.example.readexcel.util.ExcelRead;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class excelService {

    @Resource
    private MenuRepository menuRepository;

    @Resource
    private RestaurantRepository restaurantRepository;

    public void menuData() throws Exception {
        ExcelRead excelRead = new ExcelRead();
        List<String> data = excelRead.read();

        log.info("### 데이터 시작 ###");
        log.info("### 데이터 갯수 : {} ###", data.size());
        for(int i = 0; i < data.size(); i++) {
            for(int j = 0; j < 2; j++) {
                Menu menu = Menu.builder()
                        .id((long) i)
                        .food(data.get(j))
                        .foodAmount(Long.valueOf(data.get(j)))
                        .build();
                menuRepository.save(menu);
            }
        }
        log.info("### 데이터 저장 완료 ###");
    }

    public void restaurantData() throws Exception {
        ExcelRead excelRead = new ExcelRead();
        List<String> data = excelRead.read();

        log.info("### 데이터 사이즈" + data.size());
        log.info("### 데이터 갯수 : {} ###", data.size());
        for(int i = 0; i < data.size(); i++) {
            for(int j = 0; j < 4; j++) {
                Restaurant restaurant = Restaurant.builder()
                        .id((long) i)
                        .name(data.get(j))
                        .address(data.get(j))
                        .cook(data.get(j))
                        .build();
                restaurantRepository.save(restaurant);
            }
        }
        log.info("### 데이터 저장 완료 ###");
    }


}
