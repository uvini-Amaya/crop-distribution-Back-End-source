package com.example.cropdistributionms.service;
import com.example.cropdistributionms.dto.UserDTO;
import com.example.cropdistributionms.entity.User;
import com.example.cropdistributionms.repo.UserRepo;
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

public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;
    public String saveUser(UserDTO userDTO){
        if(userRepo.existsById(userDTO.getUserId())){
            return VarList.RSP_DUPLICATED;
        }else{

            userRepo.save(modelMapper.map(userDTO,User.class));
            return VarList.RSP_SUCCESS;
        }
    }

    public String updateUser(UserDTO userDTO){
        if(userRepo.existsById(userDTO.getUserId())){
            userRepo.save(modelMapper.map(userDTO, User.class));

            return VarList.RSP_SUCCESS;

        }else{
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public List<UserDTO> getAllUser(){

            List<User> userList=userRepo.findAll();
            return modelMapper.map(userList,new TypeToken<ArrayList<UserDTO>>(){
            }.getType());

    }

    public UserDTO searchUser(int userId){
        if(userRepo.existsById(userId)){
            User user = userRepo.findById(userId).orElse(null);
            return modelMapper.map(user, UserDTO.class);


        }else{
           return null;
        }
    }


    public String deleteUser(int userId){
        if(userRepo.existsById(userId)){
            userRepo.deleteById(userId);
            return VarList.RSP_SUCCESS;

        }else{
           return VarList.RSP_NO_DATA_FOUND;
        }
    }

}
