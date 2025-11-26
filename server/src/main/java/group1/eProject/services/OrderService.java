package group1.eProject.services;

import group1.eProject.entities.Order;

import java.util.List;

public interface OrderService {
    List<Order> getOrders(int customerId);
    Order getOrderById(int id);
    Order saveOrder(Order order);
    void deleteOrder(int id);
}