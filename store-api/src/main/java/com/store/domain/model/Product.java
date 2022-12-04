package com.store.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product extends AbstractAggregateRoot<Product> {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer inventory;

    private String brand;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String productType;

    @Column(nullable = false)
    private Boolean active;

    @ManyToOne
    @JoinTable(name = "product_department", joinColumns = @JoinColumn(name = "product_id"),
                inverseJoinColumns = @JoinColumn(name = "department_id"))
    private Department department;

    public void activate() {
        setActive(true);
    }

    public void deactivate() {
        setActive(false);
    }

    public void changePrice(BigDecimal newPrice) {
        setPrice(newPrice);
    }

    public void chageInventory(Integer newInventory) {
        setInventory(newInventory);
    }
}
