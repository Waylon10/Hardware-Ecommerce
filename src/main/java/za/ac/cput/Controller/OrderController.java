package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.service.OrderItemService;
import za.ac.cput.service.OrderService;
import java.util.Set;
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping("/home")
    public String home() {
        return "index.html";
    }

    @PostMapping("/create")
    public Order createOrder(@RequestBody Order order) {
        return orderService.create(order);
    }

    @GetMapping("/read/{orderID}")
    public Order readOrder(@PathVariable Long orderID) {
        return orderService.read(orderID);
    }

    @PostMapping("/update")
    public Order updateOrder(@RequestBody Order order) {
        return orderService.update(order);
    }

    @DeleteMapping("/delete/{orderID}")
    public void deleteOrder(@PathVariable Long orderID) {
        orderService.delete(orderID);
    }

    @GetMapping("/getAll")
    public Set<Order> getAllOrders() {
        return orderService.getAll();
    }

    @PostMapping("/orderItem/create")
    public OrderItem createOrderItem(@RequestBody OrderItem orderItem) {
        return orderItemService.create(orderItem);
    }

    @GetMapping("/orderItem/read/{orderItemID}")
    public OrderItem readOrderItem(@PathVariable Long orderItemID) {
        return orderItemService.read(orderItemID);
    }

    @PostMapping("/orderItem/update")
    public OrderItem updateOrderItem(@RequestBody OrderItem orderItem) {
        return orderItemService.update(orderItem);
    }

    @DeleteMapping("/orderItem/delete/{orderItemID}")
    public void deleteOrderItem(@PathVariable Long orderItemID) {
        orderItemService.delete(orderItemID);
    }

    @GetMapping("/orderItem/getAll")
    public Set<OrderItem> getAllOrderItems() {
        return orderItemService.getAll();
    }
}



