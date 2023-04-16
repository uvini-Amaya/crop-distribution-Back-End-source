package com.example.cropdistributionms.service;
import com.example.cropdistributionms.dto.CartDTO;
import com.example.cropdistributionms.entity.Cart;
import com.example.cropdistributionms.repo.CartRepo;
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

public class CartService {
    @Autowired
    private CartRepo cartRepo;
    @Autowired
    private ModelMapper modelMapper;
    public String saveCart(CartDTO cartDTO){
        if(cartRepo.existsById(cartDTO.getCartId())){
            return VarList.RSP_DUPLICATED;
        }else{

            cartRepo.save(modelMapper.map(cartDTO,Cart.class));
            return VarList.RSP_SUCCESS;
        }
    }

    public String updateCart(CartDTO cartDTO){
        if(cartRepo.existsById(cartDTO.getCartId())){
            cartRepo.save(modelMapper.map(cartDTO, Cart.class));

            return VarList.RSP_SUCCESS;

        }else{
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public List<CartDTO> getAllCart(){

        List<Cart> cartList=cartRepo.findAll();
        return modelMapper.map(cartList,new TypeToken<ArrayList<CartDTO>>(){
        }.getType());

    }

    public CartDTO searchCart(int cartId){
        if(cartRepo.existsById(cartId)){
            Cart cart = cartRepo.findById(cartId).orElse(null);
            return modelMapper.map(cart,CartDTO.class);


        }else{
            return null;
        }
    }


    public String deleteCart(int cropId){
        if(cartRepo.existsById(cropId)){
            cartRepo.deleteById(cropId);
            return VarList.RSP_SUCCESS;

        }else{
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

}