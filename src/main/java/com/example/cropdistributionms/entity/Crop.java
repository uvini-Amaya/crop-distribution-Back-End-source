package com.example.cropdistributionms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="Crop")

public class Crop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cropId;
    private int farmerId;
    private String cropName;
    private int unitPrice;
    private int amount;
    private Date suppliedDate;
    private Date expiredDate;
}

