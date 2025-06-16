package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Order;
import com.ecommerce.model.OrderItem;
import com.ecommerce.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<String> placeOrder(@RequestBody Order order) {
        if (order.getCustomerEmail() == null || order.getCustomerEmail().isEmpty()) {
            return ResponseEntity.badRequest().body("❌ Missing customer email");
        }

        for (OrderItem item : order.getItems()) {
            item.setOrder(order);
        }

        orderService.saveOrder(order);
        return ResponseEntity.ok("✅ Order placed successfully");
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<List<Order>> getOrdersByEmail(@PathVariable String email) {
        List<Order> orders = orderService.getOrdersByCustomerEmail(email);
        return ResponseEntity.ok(orders); // ✅ Always return 200, even if list is empty
    }
}

