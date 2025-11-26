package group1.eProject.api;

import group1.eProject.entities.Order;
import group1.eProject.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderApi {
    @Autowired
    private OrderService orderService;
    @GetMapping("/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Order> getOrders(@PathVariable int customerId) {
        return orderService.getOrders(customerId);
    }
    @GetMapping("/cart/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Order getOrderById(@PathVariable int id) {
        return orderService.getOrderById(id);
    }
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Order createOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable int id) {
        orderService.deleteOrder(id);
    }
}