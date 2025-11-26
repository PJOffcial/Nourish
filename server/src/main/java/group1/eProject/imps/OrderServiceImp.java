package group1.eProject.imps;

import group1.eProject.entities.Order;
import group1.eProject.entities.OrderItem;
import group1.eProject.repos.OrderItemRepo;
import group1.eProject.repos.OrderRepo;
import group1.eProject.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImp implements OrderService {
    @Autowired
    private final OrderRepo orderRepo;
    @Autowired
    private final OrderItemRepo orderItemRepo;
    public OrderServiceImp(OrderRepo orderRepo, OrderItemRepo orderItemRepo) {
        this.orderRepo = orderRepo;
        this.orderItemRepo = orderItemRepo;
    }

    @Override
    public List<Order> getOrders(int customerId) {
        return orderRepo.findByCustomerId(customerId);
    }

    @Override
    public Order getOrderById(int id) {
        return orderRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Order not found"));
    }

    @Override
    public Order saveOrder(Order order) {
        List<OrderItem> items=orderItemRepo.findByOrderId(order.getId());
        for(OrderItem orderItem:items){
            if(orderItem.getQuantity()==0) orderItemRepo.delete(orderItem);
        }
        return orderRepo.save(order);
    }

    @Override
    public void deleteOrder(int id) {
        orderRepo.deleteById(id);
    }
}