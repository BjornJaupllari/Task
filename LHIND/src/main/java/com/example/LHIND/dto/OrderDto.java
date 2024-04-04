package com.example.LHIND.dto;

import com.example.LHIND.entity.OrderItem;
import com.example.LHIND.helper.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class OrderDto {

    private int id;

    private Date sumbittedDate;

    private Status status;

    private double containerVolume;

    private List<OrderItemDto> orderItems;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

}

