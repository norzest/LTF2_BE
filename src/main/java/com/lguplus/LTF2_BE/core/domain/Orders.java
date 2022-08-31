package com.lguplus.LTF2_BE.core.domain;

import com.lguplus.LTF2_BE.api.util.converter.BillAcceptWayConverter;
import com.lguplus.LTF2_BE.api.util.converter.CustomerTypeConverter;
import com.lguplus.LTF2_BE.api.util.converter.DeliveryTypeConverter;
import com.lguplus.LTF2_BE.api.util.converter.PayWayConverter;
import com.lguplus.LTF2_BE.core.domain.enm.BillAcceptWay;
import com.lguplus.LTF2_BE.core.domain.enm.CustomerType;
import com.lguplus.LTF2_BE.core.domain.enm.DeliveryType;
import com.lguplus.LTF2_BE.core.domain.enm.PayWay;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name="orders")
@EntityListeners({AuditingEntityListener.class})
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orders_id")
    private Long id;

    @CreatedDate
    @Column(updatable = false)
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

    @Builder
    public Orders(Phone phone, Plan plan, Color color, String deliveryType, String customerType, String customerName,
                  String changePhoneNumber, String ablePhoneNumber, String customerEmail, String customerAddress, String billAcceptWay, String payWay) {
        this.phone = phone;
        this.plan = plan;
        this.color = color;
        this.deliveryType = DeliveryType.convertValue(deliveryType);
        this.customerType = CustomerType.convertValue(customerType);
        this.customerName = customerName;
        this.changePhoneNumber = changePhoneNumber;
        this.ablePhoneNumber = ablePhoneNumber;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.billAcceptWay = BillAcceptWay.convertValue(billAcceptWay);
        this.payWay = PayWay.convertValue(payWay);
    }
}
