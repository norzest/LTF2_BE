package com.lguplus.LTF2_BE.core.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// writer : 최강현
@Entity
@Getter
@NoArgsConstructor
@Table(name="phone_info")
public class PhoneInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phone_info_id")
    private Long id;

    private String cpu;

    private String display;

    private String size;

    private String weight;

    private String camera;

    private Integer memory;

    private String memoryDes;

    private Integer storage;

    private String waterproof;

    @OneToOne(mappedBy = "phoneInfo", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Phone phone;
}