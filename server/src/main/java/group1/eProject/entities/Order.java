package group1.eProject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "orders")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
    enum OrderStatus {
        Pending,
        Preparing,
        Shipping,
        Completed,
        Cancelled
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer",nullable = false)
    private User customer;
    @Column(name = "note")
    private String note;
    @Column(name = "total")
    private double total=0;
    @Column(name = "deliveryFee")
    private double deliveryFee=0;
    @Column(name = "status")
    private OrderStatus status;
    @Column(name = "report")
    private String report;
    @Column(name = "deliveryLocation")
    private String deliveryLocation;
}