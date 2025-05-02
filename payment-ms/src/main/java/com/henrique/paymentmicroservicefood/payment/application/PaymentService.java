package com.henrique.paymentmicroservicefood.payment.application;

import com.henrique.paymentmicroservicefood.payment.infrastructure.PaymentRepository;
import com.henrique.paymentmicroservicefood.shared.utils.infrastructure.Status;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Page<PaymentResponse> getAll(Pageable pagination) {
        return paymentRepository.findAll(pagination).map(p -> modelMapper.map(p, PaymentResponse.class));
    }

    public PaymentResponse getPaymentById(Long id) {
        return modelMapper.map(paymentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException()), PaymentResponse.class);
    }

    public PaymentResponse createPayment(PaymentResponse paymentResponse) {
        PaymentEntity paymentEntity = modelMapper.map(paymentResponse, PaymentEntity.class);
        paymentEntity.setStatus(Status.CREATED);

        paymentRepository.save(paymentEntity);
        return modelMapper.map(paymentEntity,PaymentResponse.class);
    }

    public PaymentResponse updatePayment(Long id,PaymentResponse paymentResponse) {
        PaymentEntity paymentEntity = modelMapper.map(paymentResponse, PaymentEntity.class);
        paymentEntity.setId(id);

        paymentEntity = paymentRepository.save(paymentEntity);
        return modelMapper.map(paymentEntity, PaymentResponse.class);
    }

    public void delete(Long id) {
        paymentRepository.deleteById(id);
    }

}
