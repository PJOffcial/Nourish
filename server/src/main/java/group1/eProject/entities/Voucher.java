package group1.eProject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "voucher")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Voucher {
    enum VoucherType {
        FIXED_AMOUNT,
        PERCENTAGE
    }
    enum VoucherTargetType{
        SHIPPING,
        PRODUCT,
        CATEGORY,
        ORDER
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "startDate")
    private Date startDate;
    @Column(name = "endDate")
    private Date endDate;
    @Column(name = "type")
    private VoucherType type;
    @Column(name = "target")
    private VoucherTargetType targetType;
    @Column(name = "targetId")
    private Integer targetId;
    @Column(name = "amount")
    private double amount;
    @Column(name = "maxDiscount")
    private Double maxDiscount;
}