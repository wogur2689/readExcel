package com.example.readexcel.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@Entity
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
}
