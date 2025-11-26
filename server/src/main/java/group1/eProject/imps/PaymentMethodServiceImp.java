package group1.eProject.imps;

import group1.eProject.entities.PaymentMethod;
import group1.eProject.repos.PaymentMethodRepo;
import group1.eProject.services.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentMethodServiceImp implements PaymentMethodService {
    @Autowired
    private PaymentMethodRepo paymentMethodRepo;
    @Override
    public List<PaymentMethod> getAllPaymentMethods() {
        return paymentMethodRepo.findAll();
    }
    @Override
    public PaymentMethod savePaymentMethod(PaymentMethod paymentMethod) {
        return paymentMethodRepo.save(paymentMethod);
    }
}