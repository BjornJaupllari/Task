package com.example.LHIND.service;

import com.example.LHIND.entity.OrderItem;

import java.util.List;

public interface OrderItemsService {
    OrderItem getOrderItemById(int id);
    List<OrderItem> getAllOrderItems();
    OrderItem createOrderItem(OrderItem orderItem);
    OrderItem updateOrderItem(OrderItem orderItem);
    void deleteOrderItem(int id);
}
