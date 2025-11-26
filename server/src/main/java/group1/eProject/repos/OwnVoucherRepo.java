package group1.eProject.repos;

import group1.eProject.entities.OwnVoucher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OwnVoucherRepo extends JpaRepository<OwnVoucher, Integer> {
    List<OwnVoucher> findByVoucherId(Integer id);
    List<OwnVoucher> findByOwnerId(Integer id);
}