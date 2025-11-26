package group1.eProject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "use_voucher")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UseVoucher {
    enum UseTarget{
        Order,
        Item
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "useTarget")
    @Enumerated(EnumType.STRING)
    private UseTarget useTarget;
    @Column(name = "target")//id cua order hoac order item
    private int target;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "voucher",nullable = false)
    private Voucher voucher;
}