package za.ac.cput.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Category;
import za.ac.cput.domain.Product;
import za.ac.cput.factory.CategoryFactory;
import za.ac.cput.factory.ProductFactory;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    //private static Blob imageBlob;
    private static Category category;
    private static Product product;
    static {
        try {
            category = CategoryFactory.createCategoryWithoutProducts("Hand Tools", "Tools for home improvement","C:\\Users\\Rupert Van Niekerk\\Documents\\ShareX\\Screenshots\\2024-04\\msedge_F7HspUtQqf.png");
            product = ProductFactory.createProduct("Drill", "Powerful drilling machine", 199.99f, "C:\\Users\\Rupert Van Niekerk\\Documents\\ShareX\\Screenshots\\2024-04\\msedge_F7HspUtQqf.png", category);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void a_create() {
        Product created = productService.create(product);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void b_read() {
        Product read = productService.read(product.getProductId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Disabled
    void c_delete() {
        productService.delete(product.getProductId());
        System.out.println("Product deleted where Product ID: " + product.getProductId());
    }

    @Test
    void d_getAll() {
        productService.getAll();
        System.out.println(productService.getAll());
    }
}