package com.example.LHIND.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class TruckDto {

    private int id;

    private String chassisNumber;

    private String licensePlate;

    private double containerVolume;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

}

