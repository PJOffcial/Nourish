package group1.eProject.imps;

import group1.eProject.entities.UseVoucher;
import group1.eProject.entities.Voucher;
import group1.eProject.repos.UseVoucherRepo;
import group1.eProject.services.UseVoucherService;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UseVoucherServiceImp implements UseVoucherService {
    @Autowired
    private UseVoucherRepo useVoucherRepo;
    @Override
    public List<Voucher> getUsedVouchers(String useTarget, Integer targetId) {
        Specification<UseVoucher> spec=((root, query, cb) -> {
            List<Predicate> predicates=new ArrayList<>();
            if(useTarget!=null && !useTarget.trim().isEmpty()){
                predicates.add(cb.equal(root.get("useTarget").as(String.class),useTarget));
            }
            if(targetId!=null){
                predicates.add(cb.equal(root.get("targetId"),targetId));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        });
        List<UseVoucher> list=useVoucherRepo.findAll(spec);
        return list.stream().map(UseVoucher::getVoucher).collect(Collectors.toList());
    }
    @Override
    public UseVoucher saveUseVoucher(UseVoucher useVoucher) {
        return useVoucherRepo.save(useVoucher);
    }
    @Override
    public void deleteUseVoucher(int id) {
        useVoucherRepo.deleteById(id);
    }
}