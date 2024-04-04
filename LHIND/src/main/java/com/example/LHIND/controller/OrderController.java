package com.example.LHIND.controller;

import com.example.LHIND.dto.OrderDto;
import com.example.LHIND.dto.OrderItemDto;
import com.example.LHIND.entity.Order;
import com.example.LHIND.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/all")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable int id) {
        Optional<Order> order = Optional.ofNullable(orderService.getOrderById(id));
        return order.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<Order> createOrder(@RequestBody OrderDto order, OrderItemDto items) {
        Order createdOrder = orderService.createOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

//    @PutMapping("/update/{id}")
//    public ResponseEntity<Order> updateOrder(@PathVariable int id, @RequestBody Order orderDetails) {
//        Order updatedOrder = orderService.updateOrder(id, orderDetails);
//        return ResponseEntity.ok(updatedOrder);
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable int id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
