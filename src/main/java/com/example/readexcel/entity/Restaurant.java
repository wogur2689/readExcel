package com.example.readexcel.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@Entity
@NoArgsConstructor
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

    @ManyToOne
    @JoinColumn(name = "menu_no")
    private Menu menu; //하나의 식당에는 여러개의 음식이 있음.

    @Builder
    public Restaurant(Long id, String name, String address, String cook, Menu menu) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cook = cook;
        this.menu = menu;
    }
}
