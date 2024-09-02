package za.ac.cput.factory;

import za.ac.cput.util.Helper;
import za.ac.cput.domain.OrderItem;

public class OrderItemFactory {

    public static OrderItem buildOrderItem(long orderID, long productID, float price, Integer quantity, float totalProductPrice) {
        if (Helper.isNullOrEmpty(String.valueOf(orderID)) || Helper.isNullOrEmpty(String.valueOf(productID))
                || Helper.isNullOrEmpty(String.valueOf(price)) || Helper.isNullOrEmpty(String.valueOf(quantity))
                || Helper.isNullOrEmpty(String.valueOf(totalProductPrice))) {
            return null;
        }

        return new OrderItem.Builder()
                .setOrderID(orderID)
                .setProductID(productID)
                .setPrice(price)
                .setQuantity(quantity)
                .setTotalProductPrice(totalProductPrice)
                .build();
    }
}
