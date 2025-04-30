package com.henrique.paymentmicroservicefood.payment.infrastructure;

import com.henrique.paymentmicroservicefood.payment.application.PaymentResponse;
import com.henrique.paymentmicroservicefood.payment.application.PaymentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/payment")

public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public Page<PaymentResponse> listPayment(@PageableDefault(size = 10) Pageable pagination) {
        return paymentService.getAll(pagination);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponse> getPaymentById(@PathVariable @NotNull Long id) {
        PaymentResponse paymentResponse = paymentService.getPaymentById(id);

        return ResponseEntity.ok(paymentResponse);
    }

    @PostMapping
    public ResponseEntity<PaymentResponse> createPayment(@RequestBody @Valid PaymentResponse paymentResponse, UriComponentsBuilder uriBuilder) {
        PaymentResponse payment = paymentService.createPayment(paymentResponse);
        URI uriPath = uriBuilder.path("/payment/{id}").buildAndExpand(payment.getId()).toUri();

        return ResponseEntity.created(uriPath).body(payment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentResponse> updatePayment(@PathVariable @NotNull Long id, @RequestBody @Valid PaymentResponse paymentResponse) {
        PaymentResponse updatedPayment = paymentService.updatePayment(id, paymentResponse);
        return ResponseEntity.ok(updatedPayment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PaymentResponse> deletePayment(@PathVariable @NotNull Long id) {
        paymentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
