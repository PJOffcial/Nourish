package group1.eProject.api;

import group1.eProject.entities.PaymentMethod;
import group1.eProject.services.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment_methods")
public class PaymentMethodApi {
    @Autowired
    private PaymentMethodService paymentMethodService;
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<PaymentMethod> getAllPaymentMethods() {
        return paymentMethodService.getAllPaymentMethods();
    }
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPaymentMethod(@RequestBody PaymentMethod paymentMethod) {
        paymentMethodService.savePaymentMethod(paymentMethod);
    }
}