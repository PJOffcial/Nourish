package group1.eProject.repos;

import group1.eProject.entities.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VoucherRepo extends JpaRepository<Voucher, Integer>, JpaSpecificationExecutor<Voucher> {

}