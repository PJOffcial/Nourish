package group1.eProject.services;

import group1.eProject.entities.UseVoucher;
import group1.eProject.entities.Voucher;

import java.util.List;

public interface UseVoucherService {
    List<Voucher> getUsedVouchers(String useTarget,Integer targetId);
    UseVoucher saveUseVoucher(UseVoucher useVoucher);
    void deleteUseVoucher(int id);
}