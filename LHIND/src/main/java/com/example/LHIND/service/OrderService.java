package com.example.LHIND.service;

import com.example.LHIND.entity.Order;

import java.util.List;

public interface OrderService {
    Order getOrderById(int id);
    List<Order> getAllOrders();
    Order createOrder(Order order);
    Order updateOrder(Order order);
    void deleteOrder(int id);
}
