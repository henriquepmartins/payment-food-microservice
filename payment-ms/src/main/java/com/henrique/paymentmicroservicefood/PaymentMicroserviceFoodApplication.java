package com.henrique.paymentmicroservicefood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEurekaClient

public class PaymentMicroserviceFoodApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMicroserviceFoodApplication.class, args);
    }
}
