package com.org.controller;


import com.org.entity.Buyer;
import com.org.entity.Order;
import com.org.model.OrderDTO;
import com.org.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/order")
    public Order crateOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.createOrder(orderDTO);
    }


    @GetMapping("/orders")
    public List<Order> getOrders() {
        List<Order> orders = orderService.getAllOrders();
        return orders;
    }

    @PutMapping("/order/{id}")
    public OrderDTO updateOrder(@PathVariable Long id, @RequestBody OrderDTO orderDTO) {
        return orderService.updateOrder(id, orderDTO);
    }

    @DeleteMapping("/order/{id}")
    String deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return "Deleted";

    }

    @GetMapping("/order/{id}")
    public Order getOrder(@PathVariable Long id) {
        return orderService.getOrder(id);
    }
}
