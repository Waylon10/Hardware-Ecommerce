package za.ac.cput.factory;

import static org.junit.jupiter.api.Assertions.*;
import za.ac.cput.domain.OrderItem;
import org.junit.jupiter.api.Test;
public class OrderItemFactoryTest {

    @Test
    void testBuildOrderItemWithAllFields() {
        OrderItem orderItem = OrderItemFactory.buildOrderItem(2202045L, 229695L, 100.0f, 2, 200.0f);

        assertNotNull(orderItem);
        System.out.println(orderItem);
    }

    @Test
    void testBuildOrderItemWithoutQuantity() {
        OrderItem orderItem = OrderItemFactory.buildOrderItem(2202045L, 229695L, 100.0f, null, 200.0f);

        assertNotNull(orderItem);
        System.out.println(orderItem);
    }
}