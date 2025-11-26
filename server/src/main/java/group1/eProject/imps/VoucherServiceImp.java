package group1.eProject.imps;

import group1.eProject.entities.Voucher;
import group1.eProject.repos.VoucherRepo;
import group1.eProject.services.VoucherService;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class VoucherServiceImp implements VoucherService {
    @Autowired
    private VoucherRepo voucherRepo;
    @Override
    public List<Voucher> getVouchers(String voucherTargetType, String keyword, Date startDate, Date endDate) {
        Specification<Voucher> spec=((root,query,cb)->{
            List<Predicate> predicates=new ArrayList<>();
            if(!"".equals(voucherTargetType)){
                predicates.add(cb.equal(root.get("voucherTargetType").as(String.class), voucherTargetType));
            }
            if(keyword!=null && !keyword.trim().isEmpty()){
                predicates.add(cb.like(cb.lower(root.get("name")), "%"+keyword.toLowerCase()+"%"));
            }
            if(startDate!=null){
                predicates.add(cb.greaterThanOrEqualTo(root.get("startDate"), startDate));
            }
            if(endDate!=null){
                predicates.add(cb.lessThanOrEqualTo(root.get("endDate"), endDate));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        });
        return voucherRepo.findAll(spec);
    }
    @Override
    public Voucher getVoucherById(int id) {
        return voucherRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Voucher not found!"));
    }
    @Override
    public Voucher saveVoucher(Voucher voucher) {
        return voucherRepo.save(voucher);
    }
    @Override
    public void deleteVoucher(int id) {
        voucherRepo.deleteById(id);
    }
}