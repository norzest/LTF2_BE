package com.lguplus.LTF2_BE.core.domain;

import com.lguplus.LTF2_BE.api.util.BillAcceptWayConverter;
import com.lguplus.LTF2_BE.api.util.CustomerTypeConverter;
import com.lguplus.LTF2_BE.api.util.DeliveryTypeConverter;
import com.lguplus.LTF2_BE.api.util.PayWayConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name="orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orders_id")
    private Long id;

    private LocalDateTime orderDate;

    @Convert(converter = DeliveryTypeConverter.class)
    private DeliveryType deliveryType;

    @Convert(converter = CustomerTypeConverter.class)
    private CustomerType customerType;

    private String customerName;

    private String changePhoneNumber;

    private String ablePhoneNumber;

    private String customerEmail;

    private String customerAddress;

    @Convert(converter = BillAcceptWayConverter.class)
    private BillAcceptWay billAcceptWay;

    @Convert(converter = PayWayConverter.class)
    private PayWay payWay;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "phone_id")
    private Phone phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id")
    private Plan plan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "color_id")
    private Color color;
}
