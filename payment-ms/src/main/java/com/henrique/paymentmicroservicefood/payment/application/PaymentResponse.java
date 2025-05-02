package com.henrique.paymentmicroservicefood.payment.application;

import com.henrique.paymentmicroservicefood.shared.utils.infrastructure.Status;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentResponse {
    private Long id;
    private BigDecimal amount;
    private String name;
    private String expirationDate;
    private String cardNumber;
    private String cardCode;
    private Status status;
    private Long orderId;
    private Long paymentMethodId;
}
