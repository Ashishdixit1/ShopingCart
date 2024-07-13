package com.org.service;

import com.org.entity.Buyer;
import com.org.entity.Order;
import com.org.model.BuyerDtO;
import com.org.model.OrderDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    Order createOrder(OrderDTO orderDTO);

    OrderDTO updateOrder(Long id, OrderDTO orderDTO);

    List<Order> getAllOrders();

    public Order getOrder(Long id);

    public void deleteOrder(Long id);

}
