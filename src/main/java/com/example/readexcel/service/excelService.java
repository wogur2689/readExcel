package com.example.readexcel.service;

import com.example.readexcel.entity.Menu;
import com.example.readexcel.entity.Restaurant;
import com.example.readexcel.repository.MenuRepository;
import com.example.readexcel.repository.RestaurantRepository;
import com.example.readexcel.util.ExcelRead;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class excelService {

    @Resource
    private MenuRepository menuRepository;

    @Resource
    private RestaurantRepository restaurantRepository;

    public void menuData() {
        ExcelRead excelRead = new ExcelRead();
        List<String> exceldata = excelRead.read();
        List<String> saveData = new ArrayList<>();
        Long j = 1L; //id

        log.info("### 데이터 시작 ###");
        log.info("### 데이터 갯수 : {} ###", exceldata.size());

        for(int i = 0; i < exceldata.size(); i++) {
            saveData.add(exceldata.get(i));

            //레스토랑의 열개수만큼 데이터가 채워지면 데이터 저장
            if(saveData.size() == 2) {
                Menu menu = Menu.builder()
                        .id(j)
                        .food(saveData.get(0))
                        .foodAmount(Long.valueOf(saveData.get(1)))
                        .build();
                menuRepository.save(menu);
                j++; //id값 증가
                saveData.clear(); //리스트 초기화
            }
        }

        log.info("### 데이터 저장 완료 ###");
    }

    public void restaurantData() {
        ExcelRead excelRead = new ExcelRead();
        List<String> exceldata = excelRead.read();
        List<String> saveData = new ArrayList<>();
        Long j = 1L; //id

        log.info("### 데이터 시작 ###");
        log.info("### 데이터 갯수 : {} ###", exceldata.size());

        for(int i = 0; i < exceldata.size(); i++) {
            saveData.add(exceldata.get(i));

            //레스토랑의 열개수만큼 데이터가 채워지면 데이터 저장
            if(saveData.size() == 6) {
                Restaurant restaurant = Restaurant.builder()
                        .id(j)
                        .name(saveData.get(0))
                        .address(saveData.get(1))
                        .cook(saveData.get(2))
                        .opening_hours(saveData.get(3))
                        .phoneNumber(saveData.get(4))
                        .remark(saveData.get(5))
                        .build();
                restaurantRepository.save(restaurant);
                j++; //id값 증가
                saveData.clear(); //리스트 초기화
            }
        }

        log.info("### 데이터 저장 완료 ###");
    }


}
