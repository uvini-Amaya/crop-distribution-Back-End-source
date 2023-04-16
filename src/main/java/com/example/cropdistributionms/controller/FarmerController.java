package com.example.cropdistributionms.controller;

import com.example.cropdistributionms.dto.FarmerDTO;
import com.example.cropdistributionms.dto.ResponseDTO;
import com.example.cropdistributionms.dto.UserDTO;
import com.example.cropdistributionms.service.FarmerService;
import com.example.cropdistributionms.service.UserService;
import com.example.cropdistributionms.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/farmer")
@CrossOrigin("http://localhost:3000")
public class FarmerController {

    @Autowired
    private FarmerService farmerService;

    @Autowired
    private ResponseDTO responseDTO;

    @PostMapping(value = "/saveFarmer")
    public ResponseEntity saveFarmer(@RequestBody FarmerDTO farmerDTO){
        try {
            String res=farmerService.saveFarmer( farmerDTO);
            if(res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(farmerDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            }else if(res.equals("06")){
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("User Already Registered.");
                responseDTO.setContent(farmerDTO);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            }else{
                responseDTO.setCode(VarList.RSP_FAIL);
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            }
        }catch (Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping (value = "/updateFarmer")
    public ResponseEntity updateFarmer(@RequestBody FarmerDTO farmerDTO){
        try {
            String resp=farmerService.updateFarmer(farmerDTO);
            if(resp.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Successful");
                responseDTO.setContent(farmerDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            }else if(resp.equals("01")){
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("Not Registered User.");
                responseDTO.setContent(farmerDTO);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            }else{
                responseDTO.setCode(VarList.RSP_FAIL);
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            }
        }catch (Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllFarmers")
    public  ResponseEntity getAllFarmer(){
        try{
            List<FarmerDTO> farmerDTOList = farmerService.getAllFarmer();
            responseDTO.setCode(VarList.RSP_SUCCESS);
            responseDTO.setMessage("Successful");
            responseDTO.setContent(farmerDTOList);
            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

        }catch (Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/searchFarmer/{farmerId}")
    public ResponseEntity searchFarmer(@PathVariable int farmerId){
        try {
            FarmerDTO farmerDTO = farmerService.searchFarmer(farmerId);
            if(farmerDTO !=null){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Successful");
                responseDTO.setContent(farmerDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);


            }else{
                responseDTO.setCode(VarList.RSP_FAIL);
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            }
        }catch (Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(ex);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping ("/deleteFarmer/{farmerId}")
    public ResponseEntity deleteFarmer(@PathVariable int farmerId){
        try {
            String res = farmerService.deleteFarmer(farmerId);
            if(res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Successful");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);


            }else{
                responseDTO.setCode(VarList.RSP_FAIL);
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            }
        }catch (Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(ex);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
