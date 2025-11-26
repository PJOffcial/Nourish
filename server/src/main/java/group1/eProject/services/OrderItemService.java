package group1.eProject.services;

import group1.eProject.entities.OrderItem;

import java.util.List;

public interface OrderItemService {
    List<OrderItem> getOrderItems(int orderId);
    void addOrderItem(int orderId, int productId);
    void saveOrderItem(OrderItem orderItem);
    void addOneItem(int id);
    void removeOneItem(int id);
    void deleteOrderItem(int id);
}