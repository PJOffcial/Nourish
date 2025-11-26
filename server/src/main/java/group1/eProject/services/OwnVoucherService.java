package group1.eProject.services;

import group1.eProject.entities.User;
import group1.eProject.entities.OwnVoucher;
import group1.eProject.entities.Voucher;

import java.util.List;

public interface OwnVoucherService {
    List<OwnVoucher> getOwnVouchers(int ownerId);
    List<User> getAccountsByVoucher(int voucherId);
    OwnVoucher addVoucher(OwnVoucher ownVoucher);
    void deleteVoucher(int id);
}