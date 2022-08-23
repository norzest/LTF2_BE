package com.lguplus.LTF2_BE.core.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name="phone_img")
public class PhoneImg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phone_img_id")
    private Long id;

    private String img;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "phone_color_id")
    private PhoneColor phoneColor;
}
