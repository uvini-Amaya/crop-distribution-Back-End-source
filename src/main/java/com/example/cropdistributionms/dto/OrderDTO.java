package com.example.cropdistributionms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class OrderDTO {
    private int orderId;
    private int orderPrice;
}
