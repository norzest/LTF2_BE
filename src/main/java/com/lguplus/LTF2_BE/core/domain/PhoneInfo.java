package com.lguplus.LTF2_BE.core.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    private String memory;

    private String storage;

    private String waterproof;

    @OneToOne(mappedBy = "phoneInfo", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Phone phone;
}
