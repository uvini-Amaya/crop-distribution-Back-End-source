package com.example.cropdistributionms.repo;

import com.example.cropdistributionms.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Integer>{

}