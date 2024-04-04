package com.example.LHIND.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Table(name = "Inventory_items")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class InventoryItems implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private double quantity;

    @Column(name = "unity_price")
    private double unityPrice;

    @Column(name = "package_volume")
    private double packageVolume;

}
