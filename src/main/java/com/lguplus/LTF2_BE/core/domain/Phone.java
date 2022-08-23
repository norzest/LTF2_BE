package com.lguplus.LTF2_BE.core.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name="phone")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phone_id")
    private Long id;

    private String titleName;

    private String titleSub;

    private String model;

    private Integer price;

    private String previewImg;

    @Convert(converter = ManuFacturingCompany.class)
    private ManuFacturingCompany manufacturingCompany;

    @Convert(converter = TelecomTech.class)
    private TelecomTech telecomTech;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "phone_info_id")
    private PhoneInfo phoneInfo;

    @OneToMany(mappedBy = "phone", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<PhoneDesImg> phoneDesImgs = new ArrayList<>();

    @OneToMany(mappedBy = "phone", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<PublicSupport> publicSupports = new ArrayList<>();

    @OneToMany(mappedBy = "phone", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Orders> orders = new ArrayList<>();

    @OneToMany(mappedBy = "phone", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<PhoneColor> phoneColors = new ArrayList<>();
}
