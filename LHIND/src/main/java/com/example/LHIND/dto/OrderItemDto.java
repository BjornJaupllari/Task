package com.example.LHIND.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class OrderItemDto {

    private int id;
    private int itemId;
    private int quantity;
}
