package com.lguplus.LTF2_BE.core.repository;

import com.lguplus.LTF2_BE.core.domain.Orders;
import com.lguplus.LTF2_BE.core.domain.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

    // DB에서 phoneId를 기준으로 startDate와 endDate 사이에 주문된 데이터를 조회한 후 반환
    List<Orders> findByPhoneIdAndOrderDateBetween(Long phoneId, LocalDateTime startDate, LocalDateTime endDate);
}
