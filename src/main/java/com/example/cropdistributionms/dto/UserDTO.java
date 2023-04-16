package com.example.cropdistributionms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class UserDTO {
    private int userId;
    private String userName;
    private String userArea;
    private String userContact;
    private String userEmail;
}
