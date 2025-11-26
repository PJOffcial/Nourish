package group1.eProject.api;

import group1.eProject.entities.UseVoucher;
import group1.eProject.entities.Voucher;
import group1.eProject.services.UseVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/use_vouchers")
public class UseVoucherApi {
    @Autowired
    private UseVoucherService useVoucherService;
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Voucher> getAllVouchers(@RequestParam String useTarget, @RequestParam Integer targetId) {
        return useVoucherService.getUsedVouchers(useTarget,targetId);
    }
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public UseVoucher saveUseVoucher(@RequestBody UseVoucher useVoucher) {
        return useVoucherService.saveUseVoucher(useVoucher);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUseVoucher(@PathVariable int id) {
        useVoucherService.deleteUseVoucher(id);
    }
}