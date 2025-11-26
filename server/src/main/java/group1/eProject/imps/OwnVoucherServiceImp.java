package group1.eProject.imps;

import group1.eProject.entities.User;
import group1.eProject.entities.OwnVoucher;
import group1.eProject.repos.OwnVoucherRepo;
import group1.eProject.services.OwnVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnVoucherServiceImp implements OwnVoucherService {
    @Autowired
    private OwnVoucherRepo ownVoucherRepo;
    @Override
    public List<OwnVoucher> getOwnVouchers(int ownerId) {
        return ownVoucherRepo.findByOwnerId(ownerId);
    }
    @Override
    public List<User> getAccountsByVoucher(int voucherId) {
        List<OwnVoucher> ownVouchers=ownVoucherRepo.findByVoucherId(voucherId);
        return ownVouchers.stream().map(OwnVoucher::getOwner).collect(Collectors.toList());
    }
    @Override
    public OwnVoucher addVoucher(OwnVoucher ownVoucher) {
        return ownVoucherRepo.save(ownVoucher);
    }

    @Override
    public void deleteVoucher(int id) {
        ownVoucherRepo.deleteById(id);
    }
}