package com.store.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Address {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String number;

    private String complement;

    @Column(nullable = false)
    private String neighborhood;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
