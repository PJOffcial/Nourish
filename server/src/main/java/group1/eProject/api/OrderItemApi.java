package group1.eProject.api;

import group1.eProject.entities.OrderItem;
import group1.eProject.services.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order_items")
public class OrderItemApi {
    @Autowired
    private OrderItemService orderItemService;
    @GetMapping("/cart/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderItem> getOrderItems(@PathVariable int orderId) {
        return orderItemService.getOrderItems(orderId);
    }
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void addOrderItem(@RequestParam int orderId,@RequestParam int productId) {
        orderItemService.addOrderItem(orderId,productId);
    }
    @PutMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public void updateOrderItem(@RequestParam OrderItem orderItem) {
        orderItemService.saveOrderItem(orderItem);
    }
    @PutMapping("/increment/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void incrementOrderItem(@PathVariable int id) {
        orderItemService.addOneItem(id);
    }
    @PutMapping("/decrement/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void decreaseOrderItem(@PathVariable int id) {
        orderItemService.removeOneItem(id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrderItem(@PathVariable int id) {
        orderItemService.deleteOrderItem(id);
    }
}