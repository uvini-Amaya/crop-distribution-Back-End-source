package com.example.cropdistributionms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class CropDTO {
    private int cropId;
    private int farmerId;
    private String cropName;
    private int unitPrice;
    private int amount;
    private Date suppliedDate;
    private Date expiredDate;
}



