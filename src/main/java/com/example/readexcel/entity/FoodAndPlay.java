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
@Table(name = "foodAndPlay")
public class FoodAndPlay extends Common implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name; //상호명

    @Column(name = "operating_time")
    private String operatingTime; //운영시간

    @Column(name = "closed")
    private String closed; //휴무

    @Column(name = "phone")
    private String phone; //전화번호

    @Column(name = "characteristic")
    private String characteristic; //특징

    @Column(name = "location")
    private String location; //위치

    @ManyToOne
    @JoinColumn(name = "foodAndPlayDetail")
    private FoodAndPlayDetail foodAndPlayDetail; //먹거리 & 놀거리 상세메뉴

    @Builder
    public FoodAndPlay(Long id, String name, String operatingTime, String closed, String phone, String characteristic, String location, FoodAndPlayDetail foodAndPlayDetail) {
        this.id = id;
        this.name = name;
        this.operatingTime = operatingTime;
        this.closed = closed;
        this.phone = phone;
        this.characteristic = characteristic;
        this.location = location;
        this.foodAndPlayDetail = foodAndPlayDetail;
    }
}
