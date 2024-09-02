package za.ac.cput.Controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.OrderFactory;
import za.ac.cput.factory.OrderItemFactory;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "/order";

    private Address address;
    private OrderItem orderItem;
    private Order order;

    @Test
    void a_readOrder() {
        address = AddressFactory.createAddress("10", "", "", "", "", "Dorset", "Cape Town", "Western Cape", "8008");
        orderItem = OrderItemFactory.buildOrderItem(1263746L, 245847363L, 299.99f, 3, 899.97f);
        order = OrderFactory.buildOrder(12345L, LocalDate.now(), address, 150.75f, "Processing", new HashSet<>(Collections.singletonList(orderItem)));

        String url = BASE_URL + "/read/" + order.getOrderID();
        System.out.println("URL: " + url);
        ResponseEntity<Order> response = restTemplate.getForEntity(url, Order.class);
        assertEquals(order.getOrderID(), response.getBody().getOrderID());
        System.out.println("READ: " + response.getBody());
    }

    @Test
    void b_deleteOrder() {
        address = AddressFactory.createAddress("10", "", "", "", "", "Dorset", "Cape Town", "Western Cape", "8008");
        orderItem = OrderItemFactory.buildOrderItem(1263746L, 245847363L, 299.99f, 3, 899.97f);
        order = OrderFactory.buildOrder(12345L, LocalDate.now(), address, 150.75f, "Processing", new HashSet<>(Collections.singletonList(orderItem)));

        String url = BASE_URL + "/delete/" + order.getOrderID();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
        System.out.println("Order successfully deleted!");
    }

    @Test
    void c_getAllOrders() {
        String url = BASE_URL + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("SHOW ALL: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test
    void d_readOrderItem() {
        orderItem = OrderItemFactory.buildOrderItem(1263746L, 245847363L, 299.99f, 3, 899.97f);

        String url = BASE_URL + "/orderItem/read/" + orderItem.getOrderItemID();
        System.out.println("URL: " + url);
        ResponseEntity<OrderItem> response = restTemplate.getForEntity(url, OrderItem.class);
        assertEquals(orderItem.getOrderItemID(), response.getBody().getOrderItemID());
        System.out.println("READ: " + response.getBody());
    }

    @Test
    void e_deleteOrderItem() {
        orderItem = OrderItemFactory.buildOrderItem(1263746L, 245847363L, 299.99f, 3, 899.97f);

        String url = BASE_URL + "/orderItem/delete/" + orderItem.getOrderItemID();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
        System.out.println("OrderItem successfully deleted!");
    }

    @Test
    void f_getAllOrderItems() {
        String url = BASE_URL + "/orderItem/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("SHOW ALL: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}




