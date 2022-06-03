package com.example.readexcel.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "menu")
public class Menu extends Common implements Serializable {
    @Id
    @Column(name = "id")
    private Long id; //id

    @Column(name = "food", length = 20)
    private String food; //음식

    @Column(name = "food_amount", columnDefinition = "default 0")
    private Long foodAmount; //가격
}
