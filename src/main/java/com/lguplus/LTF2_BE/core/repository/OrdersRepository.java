package com.lguplus.LTF2_BE.core.repository;

import com.lguplus.LTF2_BE.core.domain.Orders;
import com.lguplus.LTF2_BE.core.domain.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
