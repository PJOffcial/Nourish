package group1.eProject.api;

import group1.eProject.entities.Voucher;
import group1.eProject.services.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/vouchers")
public class VoucherApi {
    @Autowired
    private VoucherService voucherService;
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Voucher> getVouchers(@RequestParam String voucherTargetType,@RequestParam String keyword,@RequestParam Date startDate,@RequestParam Date endDate) {
        return voucherService.getVouchers(voucherTargetType, keyword, startDate, endDate);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Voucher getVoucher(@PathVariable int id) {
        return voucherService.getVoucherById(id);
    }
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Voucher createVoucher(@RequestBody Voucher voucher) {
        return voucherService.saveVoucher(voucher);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVoucher(@PathVariable int id) {
        voucherService.deleteVoucher(id);
    }
}