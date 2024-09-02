package za.ac.cput.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.factory.OrderItemFactory;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class OrderItemServiceTest {

    @Autowired
    private OrderItemService orderItemService;

    private static OrderItem orderItem = OrderItemFactory.buildOrderItem(
            1263746L, 245847363L, 299.99f, 3, 899.97f);

    @Test
    void a_create() {
        OrderItem created = orderItemService.create(orderItem);
        assertNotNull(created);
        System.out.println("Created: " + created);
    }
    @Test
    void b_read() {
        OrderItem created = orderItemService.create(orderItem);
        assertNotNull(created);

        Long orderItemId = created.getOrderItemID();
        OrderItem read = orderItemService.read(orderItemId);

        assertNotNull(read);
        assertEquals(orderItemId, read.getOrderItemID());
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        OrderItem newOrderItem = new OrderItem.Builder().copy(orderItem).setOrderID(145678L).build();
        OrderItem updated = orderItemService.update(newOrderItem);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Disabled
    void d_delete() {
        orderItemService.delete(orderItem.getOrderItemID());
        System.out.println("Deleted: " + orderItem.getOrderItemID());
    }

    @Test
    void e_getAll() {
        System.out.println("Get All: " + orderItemService.getAll());
    }
}


