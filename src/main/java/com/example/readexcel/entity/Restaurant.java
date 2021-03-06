package com.example.readexcel.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "restaurant")
public class Restaurant extends Common implements Serializable {
    @Id
    @Column(name = "id")
    private Long id; //id

    @Column(name = "name", length = 20)
    private String name; //식당이름

    @Column(name = "address", length = 100)
    private String address; //식당위치

    @Column(name = "cook", length = 50)
    private String cook; //요리(종류)

    @Column(name = "opening_hours")
    private String opening_hours; //영업시간

    @Column(name = "remark")
    private String remark; //비고

    @Column(name = "phone_number")
    private String phoneNumber; //식당전화번호

    @ManyToOne
    @JoinColumn(name = "menu_no")
    private Menu menu; //하나의 식당에는 여러개의 음식이 있음.
}
