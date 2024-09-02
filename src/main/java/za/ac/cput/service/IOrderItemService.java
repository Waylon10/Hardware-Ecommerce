package za.ac.cput.service;

import za.ac.cput.domain.OrderItem;
import java.util.Set;

public interface IOrderItemService extends IService<OrderItem, Long> {
    OrderItem create(OrderItem orderItem);
    OrderItem read(Long id);
    OrderItem update(OrderItem orderItem);
    void delete(Long id);
    Set<OrderItem> getAll();
}
