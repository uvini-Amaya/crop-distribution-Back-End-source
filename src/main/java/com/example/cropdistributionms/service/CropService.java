package com.example.cropdistributionms.service;
import com.example.cropdistributionms.dto.CropDTO;
import com.example.cropdistributionms.entity.Crop;
import com.example.cropdistributionms.repo.CropRepo;
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

public class CropService {
    @Autowired
    private CropRepo cropRepo;
    @Autowired
    private ModelMapper modelMapper;
    public String saveCrop(CropDTO cropDTO){
        if(cropRepo.existsById(cropDTO.getCropId())){
            return VarList.RSP_DUPLICATED;
        }else{

            cropRepo.save(modelMapper.map(cropDTO,Crop.class));
            return VarList.RSP_SUCCESS;
        }
    }

    public String updateCrop(CropDTO cropDTO){
        if(cropRepo.existsById(cropDTO.getCropId())){
            cropRepo.save(modelMapper.map(cropDTO, Crop.class));

            return VarList.RSP_SUCCESS;

        }else{
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public List<CropDTO> getAllCrop(){

        List<Crop> cropList=cropRepo.findAll();
        return modelMapper.map(cropList,new TypeToken<ArrayList<CropDTO>>(){
        }.getType());
    }

    public CropDTO searchCrop(int cropId){
        if(cropRepo.existsById(cropId)){
            Crop crop = cropRepo.findById(cropId).orElse(null);
            return modelMapper.map(crop, CropDTO.class);

        }else{
            return null;
        }
    }


    public String deleteCrop(int cropId){
        if(cropRepo.existsById(cropId)){
            cropRepo.deleteById(cropId);
            return VarList.RSP_SUCCESS;

        }else{
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

}
