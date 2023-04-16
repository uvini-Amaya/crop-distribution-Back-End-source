package com.example.cropdistributionms.service;
import com.example.cropdistributionms.dto.FarmerDTO;
import com.example.cropdistributionms.dto.UserDTO;
import com.example.cropdistributionms.entity.Farmer;
import com.example.cropdistributionms.entity.User;
import com.example.cropdistributionms.repo.FarmerRepo;
import com.example.cropdistributionms.util.VarList;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional

public class FarmerService {
    @Autowired
    private FarmerRepo farmerRepo;
    @Autowired
    private ModelMapper modelMapper;
    public String saveFarmer(FarmerDTO farmerDTO){
        if(farmerRepo.existsById(farmerDTO.getFarmerId())){
            return VarList.RSP_DUPLICATED;
        }else{

            farmerRepo.save(modelMapper.map(farmerDTO,Farmer.class));
            return VarList.RSP_SUCCESS;
        }
    }

    public String updateFarmer(FarmerDTO farmerDTO){
        if(farmerRepo.existsById(farmerDTO.getFarmerId())){
            farmerRepo.save(modelMapper.map(farmerDTO, Farmer.class));

            return VarList.RSP_SUCCESS;

        }else{
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public List<FarmerDTO> getAllFarmer(){
        List<Farmer> farmerList=farmerRepo.findAll();
        return modelMapper.map(farmerList,new TypeToken<ArrayList<FarmerDTO>>(){
        }.getType());
    }

    public FarmerDTO searchFarmer(int farmerId){
        if(farmerRepo.existsById(farmerId)){
            Farmer farmer =farmerRepo.findById(farmerId).orElse(null);
            return modelMapper.map(farmer, FarmerDTO.class);


        }else{
            return null;
        }
    }

    public String deleteFarmer(int farmerId){
        if(farmerRepo.existsById(farmerId)){
            farmerRepo.deleteById(farmerId);
            return VarList.RSP_SUCCESS;

        }else{
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

}