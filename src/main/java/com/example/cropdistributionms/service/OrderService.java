package com.example.cropdistributionms.service;
import com.example.cropdistributionms.dto.OrderDTO;
import com.example.cropdistributionms.entity.Order;
import com.example.cropdistributionms.repo.OrderRepo;
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

public class OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private ModelMapper modelMapper;
    public String saveOrder(OrderDTO orderDTO){
        if(orderRepo.existsById(orderDTO.getOrderId())){
            return VarList.RSP_DUPLICATED;
        }else{

            orderRepo.save(modelMapper.map(orderDTO,Order.class));
            return VarList.RSP_SUCCESS;
        }
    }

    public String updateOrder(OrderDTO orderDTO){
        if(orderRepo.existsById(orderDTO.getOrderId())){
            orderRepo.save(modelMapper.map(orderDTO, Order.class));

            return VarList.RSP_SUCCESS;

        }else{
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public List<OrderDTO> getAllOrder(){

        List<Order> orderList=orderRepo.findAll();
        return modelMapper.map(orderList,new TypeToken<ArrayList<OrderDTO>>(){
        }.getType());

    }

    public OrderDTO searchOrder(int orderId){
        if (orderRepo.existsById(orderId)){
            Order order = orderRepo.findById(orderId).orElse(null);
            return modelMapper.map(order, OrderDTO.class);


        }else{
            return null;
        }
    }


    public String deleteOrder(int orderId){
        if(orderRepo.existsById(orderId)){
            orderRepo.deleteById(orderId);
            return VarList.RSP_SUCCESS;

        }else{
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

}