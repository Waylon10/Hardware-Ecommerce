package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.factory.CustomerFactory;

import java.util.Collections;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    private static final Contact contact = ContactFactory.createContact("test3@gmail.com", "02189456123");
    private static final Address address = AddressFactory.createAddress("12", "Test Street", "Grabouw", "Western Cape", "7160",null);

    private static final Customer customer = CustomerFactory.createCustomer(
            "test3@gmail.com", "Connor", "McGregor", contact, "123456", (Set<Address>) Collections.singletonList(address));

    @Test
    @Order(1)
    void a_create() {
        Customer created = customerService.create(customer);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    @Order(2)
    void b_read() {
        Customer read = customerService.read(customer.getUserId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(3)
    @Disabled
    void c_update() {
        Customer newCustomer = customer.toBuilder()
                .firstName("Johnathan")
                .build();
        Customer updated = customerService.update(newCustomer);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Disabled
    @Order(4)
    void d_delete() {
        customerService.delete(customer.getUserId());
        System.out.println("Customer Deleted Where User ID = " + customer.getUserId());
    }

    @Test
    @Order(5)
    void e_getAll() {
        System.out.println(customerService.getAll());
    }
}
