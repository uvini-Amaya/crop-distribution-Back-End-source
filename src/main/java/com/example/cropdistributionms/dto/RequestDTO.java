package com.example.cropdistributionms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class RequestDTO {
    private int RequestId;
    private int CropId;
    private Date wantedDate;
    private int userId;
    private int wantedAmount;
}
