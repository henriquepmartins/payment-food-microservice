package com.henrique.paymentmicroservicefood.payment.infrastructure;

import com.henrique.paymentmicroservicefood.payment.application.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
}
