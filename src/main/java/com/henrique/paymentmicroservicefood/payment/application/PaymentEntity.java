package com.henrique.paymentmicroservicefood.payment.application;

import com.henrique.paymentmicroservicefood.shared.utils.infrastructure.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "payment")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    
    @NotNull
    @Positive
    private BigDecimal amount;
    
    @NotBlank
    @Size(max = 100)
    private String name;

    @NotBlank
    @Size(max = 7)
    private String expirationDate;

    @NotBlank
    @Size(max = 19)
    private String cardNumber;

    @NotBlank
    @Size(min = 3, max = 3)
    private String cardCode;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    @NotNull
    private Long orderId;

    @NotNull
    private Long paymentMethodId;
}
