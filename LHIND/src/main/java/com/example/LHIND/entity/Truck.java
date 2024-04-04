package com.example.LHIND.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="Truck")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Truck implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name="chassis_number", unique = true)
    private String chassisNumber;

    @Column(name="license_plate", unique = true)
    private String licensePlate;

    @Column(name = "container_volume")
    private double containerVolume;

    @Column(name="created_at")
    private Date createdAt;

    @Column(name="updated_at")
    private Date updatedAt;

    @Column(name="deleted_at")
    private Date deletedAt;

}
