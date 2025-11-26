package group1.eProject.imps;

import group1.eProject.entities.Order;
import group1.eProject.entities.OrderItem;
import group1.eProject.entities.Product;
import group1.eProject.repos.OrderItemRepo;
import group1.eProject.repos.OrderRepo;
import group1.eProject.repos.ProductRepo;
import group1.eProject.services.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImp implements OrderItemService {
    @Autowired
    private OrderItemRepo orderItemRepo;
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private ProductRepo productRepo;
    @Override
    public List<OrderItem> getOrderItems(int orderId) {
        return orderItemRepo.findByOrderId(orderId);
    }

    @Override
    public void addOrderItem(int orderId, int productId) {
        Product product=productRepo.findById(productId)
                .orElseThrow(()->new RuntimeException("Product not found"));
        OrderItem orderItem = new OrderItem();
        Order order = orderRepo.getReferenceById(orderId);
        orderItem.setOrder(order);
        orderItem.setProduct(product);
        orderItem.setNetPrice(product.getPrice());
        orderItem.setQuantity(1);
        orderItemRepo.save(orderItem);
    }

    @Override
    public void saveOrderItem(OrderItem orderItem) {
        orderItemRepo.save(orderItem);
    }

    @Override
    public void addOneItem(int id) {
        OrderItem orderItem = orderItemRepo.getReferenceById(id);
        orderItem.setQuantity(orderItem.getQuantity() + 1);
        orderItemRepo.save(orderItem);
    }

    @Override
    public void removeOneItem(int id) {
        OrderItem orderItem = orderItemRepo.getReferenceById(id);
        if(orderItem.getQuantity()>=1) {
            orderItem.setQuantity(orderItem.getQuantity() - 1);
            orderItemRepo.save(orderItem);
        }
    }

    @Override
    public void deleteOrderItem(int id) {
        orderItemRepo.deleteById(id);
    }
}