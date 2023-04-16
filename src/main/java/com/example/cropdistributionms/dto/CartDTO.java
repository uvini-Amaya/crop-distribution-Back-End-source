package com.example.cropdistributionms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class CartDTO {
    private int cartId;
    private int unitPrice;
    private int cropId;
    private int amount;
    private int totalPrice;

}
