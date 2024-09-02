package za.ac.cput.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class OrderItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderItemID;
    private long orderID;
    private long productID;
    private float price;
    private Integer quantity;
    private float totalProductPrice;

    protected OrderItem() {
    }

    public OrderItem(Builder builder) {
        this.orderItemID = builder.orderItemID;
        this.orderID = builder.orderID;
        this.productID = builder.productID;
        this.price = builder.price;
        this.quantity = builder.quantity;
        this.totalProductPrice = builder.totalProductPrice;
    }

    public long getOrderItemID() {
        return orderItemID;
    }

    public long getOrderID() {
        return orderID;
    }

    public long getProductID() {
        return productID;
    }

    public float getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public float getTotalProductPrice() {
        return totalProductPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(orderItemID, orderItem.orderItemID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderItemID);
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderItemID=" + orderItemID +
                ", orderID=" + orderID +
                ", productID=" + productID +
                ", price=" + price +
                ", quantity=" + quantity +
                ", totalProductPrice=" + totalProductPrice +
                '}';
    }

    public static class Builder {
        private long orderItemID;
        private long orderID;
        private long productID;
        private float price;
        private Integer quantity;
        private float totalProductPrice;

        public Builder setOrderItemID(long orderItemID) {
            this.orderItemID = orderItemID;
            return this;
        }

        public Builder setOrderID(long orderID) {
            this.orderID = orderID;
            return this;
        }

        public Builder setProductID(long productID) {
            this.productID = productID;
            return this;
        }

        public Builder setPrice(float price) {
            this.price = price;
            return this;
        }

        public Builder setQuantity(Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setTotalProductPrice(float totalProductPrice) {
            this.totalProductPrice = totalProductPrice;
            return this;
        }

        public Builder copy( OrderItem orderItem) {

            this.orderItemID = orderItem.orderItemID;
            this.orderID = orderItem.orderID;
            this.productID = orderItem.productID;
            this.price = orderItem.price;
            this.quantity = orderItem.quantity;
            this.totalProductPrice = orderItem.totalProductPrice;
            return this;
        }

        public OrderItem build() {
            return new OrderItem(this);
        }
    }
}
