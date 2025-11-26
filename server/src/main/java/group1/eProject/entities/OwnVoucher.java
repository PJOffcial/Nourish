package group1.eProject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "own_voucher")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OwnVoucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "voucher",nullable = false)
    private Voucher voucher;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner",nullable = false)
    private User owner;
    @Column(name = "stock")
    private int stock;
}