package com.example.readexcel.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "menu")
public class Menu extends Common implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id; //id

    @Column(name = "name", length = 100)
    private String name; //음식

    @Column(name = "menu_create_by", length = 100)
    private String menuCreateBy; //가격

    @Builder
    public Menu(Long id, String name, String menuCreateBy) {
        this.id = id;
        this.name = name;
        this.menuCreateBy = menuCreateBy;
    }
}
