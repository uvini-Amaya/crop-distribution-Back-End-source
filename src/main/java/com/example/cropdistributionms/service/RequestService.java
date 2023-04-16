package com.example.cropdistributionms.service;
import com.example.cropdistributionms.dto.RequestDTO;
import com.example.cropdistributionms.entity.Request;
import com.example.cropdistributionms.repo.RequestRepo;
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

public class RequestService {
    @Autowired
    private RequestRepo requestRepo;
    @Autowired
    private ModelMapper modelMapper;
    public String saveRequest(RequestDTO requestDTO){
        if(requestRepo.existsById(requestDTO.getUserId())){
            return VarList.RSP_DUPLICATED;
        }else{

            requestRepo.save(modelMapper.map(requestDTO,Request.class));
            return VarList.RSP_SUCCESS;
        }
    }

    public String updateRequest(RequestDTO requestDTO){
        if(requestRepo.existsById(requestDTO.getRequestId())){
           requestRepo.save(modelMapper.map(requestDTO, Request.class));

            return VarList.RSP_SUCCESS;

        }else{
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public List<RequestDTO> getAllRequest(){

        List<Request> requestList=requestRepo.findAll();
        return modelMapper.map(requestList,new TypeToken<ArrayList<RequestDTO>>(){
        }.getType());

    }

    public RequestDTO searchRequest(int requestId){
        if(requestRepo.existsById(requestId)){
            Request request = requestRepo.findById(requestId).orElse(null);
            return modelMapper.map(request, RequestDTO.class);


        }else{
            return null;
        }
    }


    public String deleteRequest(int requestId){
        if(requestRepo.existsById(requestId)){
            requestRepo.deleteById(requestId);
            return VarList.RSP_SUCCESS;

        }else{
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

}
