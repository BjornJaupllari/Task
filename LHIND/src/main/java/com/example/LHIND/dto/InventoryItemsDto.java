package com.example.LHIND.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class InventoryItemsDto {

    private int id;

    private String name;

    private double quantity;

    private double unityPrice;

    private double packageVolume;

}
