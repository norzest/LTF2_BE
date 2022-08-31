package com.lguplus.LTF2_BE.core.domain;

import com.lguplus.LTF2_BE.api.util.converter.MediaServiceConverter;
import com.lguplus.LTF2_BE.core.domain.enm.MediaService;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name="plan_media_service")
public class PlanMediaService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plan_media_service_id")
    private Long id;

    @Convert(converter = MediaServiceConverter.class)
    private MediaService mediaService;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id")
    private Plan plan;
}
