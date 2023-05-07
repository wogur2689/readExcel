package com.example.readexcel.entity;

import lombok.*;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Entity
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "foodAndPlay")
public class FoodAndPlay extends Common implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Comment("푸드그룹")
    @Column(name = "food_group")
    private String foodGroup;

    @Comment("상호명")
    @Column(name = "name")
    private String name;

    @Comment("이미지 경로")
    @Column(name = "img_link")
    private String imgLink;

    @Comment("추천여부")
    @Column(name = "recommend")
    private Boolean recommend;

    @Comment("운영시간")
    @Column(name = "operating_time")
    private String operatingTime;

    @Comment("휴무")
    @Column(name = "closed")
    private String closed;

    @Comment("전화번호")
    @Column(name = "phone")
    private String phone;

    @Comment("특징")
    @Column(name = "characteristic")
    private String characteristic;

    @Comment("위치")
    @Column(name = "location")
    private String location;

    @Builder
    public FoodAndPlay(Long id, String foodGroup, String name, String imgLink, Boolean recommend, String operatingTime, String closed, String phone, String characteristic, String location) {
        this.id = id;
        this.foodGroup = foodGroup;
        this.name = name;
        this.imgLink = imgLink;
        this.recommend = recommend;
        this.operatingTime = operatingTime;
        this.closed = closed;
        this.phone = phone;
        this.characteristic = characteristic;
        this.location = location;
    }
}
