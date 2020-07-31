package com.domaranskiy.entities.models.order;

import com.domaranskiy.entities.models.product.ProductTypes;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private String userName;
    private String productName;
    private ProductTypes productTypes;
    private int quantity;
    private OrderStatus orderStatus;
    private OrderEditStatus editStatus;

    public Order(String userName,
                 String productName,
                 ProductTypes productTypes,
                 int quantity,
                 OrderStatus orderStatus,
                 OrderEditStatus editStatus
    ) {
        this.userName = userName;
        this.productName = productName;
        this.productTypes = productTypes;
        this.quantity = quantity;
        this.orderStatus = orderStatus;
        this.editStatus = editStatus;
    }
}