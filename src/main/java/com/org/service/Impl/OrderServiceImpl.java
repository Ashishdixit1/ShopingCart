package com.org.service.Impl;

import com.org.entity.Buyer;
import com.org.entity.Order;
import com.org.entity.Product;
import com.org.model.OrderDTO;
import com.org.repository.OrderRepository;
import com.org.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    OrderRepository orderRepository;

    public Order createOrder(OrderDTO orderDTO) {
        if (orderDTO != null) {
            Order order = new Order();
            order.setQuantity(orderDTO.getQuantity());
            order.setPrice(orderDTO.getPrice());

            Buyer buyer = new Buyer();
            buyer.setId(orderDTO.getBuyerId());
            order.setBuyer(buyer);

            Product product = new Product();
            product.setProductId(orderDTO.getProductId());
            order.setProduct(product);

            orderRepository.save(order);
            return order;
        }
        return null;
    }

    @Override
    public OrderDTO updateOrder(Long id, OrderDTO orderDTO) {
        Optional<Order> orders = orderRepository.findById(id);
        if (orders.isPresent()) {
            Order order = orders.get();
            order.setQuantity(orderDTO.getQuantity());
            order.setPrice(orderDTO.getPrice());

            orderRepository.save(order);
            return orderDTO;
        }
        return null;
    }


    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrder(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
