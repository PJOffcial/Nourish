package group1.eProject.services;

import group1.eProject.entities.PaymentMethod;

import java.util.List;

public interface PaymentMethodService {
    List<PaymentMethod> getAllPaymentMethods();
    PaymentMethod savePaymentMethod(PaymentMethod paymentMethod);
}