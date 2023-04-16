package com.example.cropdistributionms.repo;

import com.example.cropdistributionms.entity.Crop;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CropRepo extends JpaRepository<Crop,Integer>{


}