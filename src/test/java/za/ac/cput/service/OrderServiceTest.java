package za.ac.cput.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.OrderFactory;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class OrderServiceTest {
@Autowired
private OrderService orderService;

private static Address address = AddressFactory.createAddress("10", "", "", "",
    "", "Dorset", "Cape Town", "Western Cape", "8008");

private static Set<OrderItem> orderItems = new HashSet<>();
private static Order order = OrderFactory.buildOrder(
        12345L, LocalDate.now(), address, 150.75f, "Processing", orderItems
);
    @Test
    void a_create() {
        Order created = orderService.create(order);
        assertNotNull(created);
        assertEquals(order.getOrderID(), created.getOrderID());
        System.out.println("Created: " + created);
    }
    @Test
    void b_read() {
        Order read = orderService.read(order.getOrderID());
        assertNotNull(read);
        System.out.println(read);
    }
    @Test
    void c_update() {
        Order created = orderService.create(order);
        Order newOrder = new Order.Builder().copy(created).setOrderStatus("Shipped").build();
        Order updated = orderService.update(newOrder);
        assertNotNull(updated);
        assertEquals("Shipped", updated.getOrderStatus());
        System.out.println("Updated: " + updated);
    }
    @Test
    @Disabled
    void d_delete() {
        Order created = orderService.create(order);
        orderService.delete(created.getOrderID());
        Order deleted = orderService.read(created.getOrderID());
        assertNull(deleted);
        System.out.println("Deleted: " + created.getOrderID());
    }
    @Test
    void e_getAll() {
        orderService.create(order);
        Set<Order> orders = orderService.getAll();
        assertNotNull(orders);
        assertFalse(orders.isEmpty());
        System.out.println("Get All: " + orders);
    }
}