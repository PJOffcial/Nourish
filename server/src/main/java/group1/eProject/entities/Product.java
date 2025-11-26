package group1.eProject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "product")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "image")
    private String image;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private double price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category", nullable = false)
    private Category category;
    @Column(name = "brand")
    private String brand;
    @Column(name = "stock")
    private int stock;
    @Column(name = "unit")
    private String unit; //hộp,túi,quả,kg,...
    @Column(name = "maxStars")
    private int maxStars;
    @Column(name = "totalStars")
    private int totalStars;
}