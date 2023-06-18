package com.example.readexcel.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "foodAndPlayDetail")
public class FoodAndPlayDetail extends Common implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "food_id")
    private String foodId; //먹거리 id

    @Column(name = "menu_name")
    private String menuName; //메뉴명

    @Column(name = "price")
    private String price; //가격

    @Column(name = "menuImgLink")
    private String menuImgLink; //메뉴 이미지

    @Builder
    public FoodAndPlayDetail(Long id, String foodId, String menuName, String price, String menuImgLink) {
        this.id = id;
        this.foodId = foodId;
        this.menuName = menuName;
        this.price = price;
        this.menuImgLink = menuImgLink;
    }
}
