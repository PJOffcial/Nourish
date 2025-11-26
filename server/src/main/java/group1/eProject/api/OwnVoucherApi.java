package group1.eProject.api;

import group1.eProject.entities.OwnVoucher;
import group1.eProject.entities.User;
import group1.eProject.services.OwnVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/own_vouchers")
public class OwnVoucherApi {
    @Autowired
    private OwnVoucherService ownVoucherService;
    @GetMapping("/vouchers/{ownerId}")
    @ResponseStatus(HttpStatus.OK)
    public List<OwnVoucher> getVouchers(@PathVariable int ownerId) {
        return ownVoucherService.getOwnVouchers(ownerId);
    }
    @GetMapping("/users/{voucherId}")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUsers(@PathVariable int voucherId) {
        return ownVoucherService.getAccountsByVoucher(voucherId);
    }
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public OwnVoucher addVoucher(@RequestBody OwnVoucher ownVoucher) {
        return ownVoucherService.addVoucher(ownVoucher);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVoucher(@PathVariable int id) {
        ownVoucherService.deleteVoucher(id);
    }
}