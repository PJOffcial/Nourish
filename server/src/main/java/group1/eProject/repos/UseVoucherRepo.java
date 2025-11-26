package group1.eProject.repos;

import group1.eProject.entities.UseVoucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface UseVoucherRepo extends JpaRepository<UseVoucher, Integer>, JpaSpecificationExecutor<UseVoucher> {
    List<UseVoucher> findByVoucherId(int voucherId);
    List<UseVoucher> findByOrderId(int orderId);
}