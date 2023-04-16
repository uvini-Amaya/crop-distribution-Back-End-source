package com.example.cropdistributionms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class FarmerDTO {
    private int farmerId;
    private String farmerName;
    private String farmerArea;
    private String farmerContact;
    private String farmerEmail;
}