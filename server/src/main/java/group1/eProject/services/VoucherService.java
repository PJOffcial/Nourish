package group1.eProject.services;

import group1.eProject.entities.Voucher;

import java.util.Date;
import java.util.List;

public interface VoucherService {
    List<Voucher> getVouchers(String voucherTargetType, String keyword, Date startDate, Date endDate);
    Voucher getVoucherById(int id);
    Voucher saveVoucher(Voucher voucher);
    void deleteVoucher(int id);
}