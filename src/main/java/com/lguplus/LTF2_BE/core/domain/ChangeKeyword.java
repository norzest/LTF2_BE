package com.lguplus.LTF2_BE.core.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// writer : 심영효
@Entity
@Getter
@NoArgsConstructor
@Table(name="change_keyword")
public class ChangeKeyword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "change_keyword_id")
    private Long id;

    private String beforeWord;

    private String afterWord;
}
