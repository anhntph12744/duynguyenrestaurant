package com.restarant.backend.service.utils;

import com.restarant.backend.entity.Account;
import com.restarant.backend.entity.Customer;
import com.restarant.backend.repository.CustomerRepository;
import com.restarant.backend.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class JwtServiceUtils {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private CustomerRepository customerRepository;

    public Account getAccountByToken(HttpServletRequest request) {
//        String token = request.getHeader("token");
//        if(!jwtUtils.validateJwtToken(token)){
//            return null;
//        }
//        String username = jwtUtils.getUserNameFromJwtToken(token);
        return null;
    }
    public String getUserName(HttpServletRequest request){
        String token = request.getHeader("token");
        return jwtUtils.getUserNameFromJwtToken(token);
    }

    //TODO
    /**
     * Lấy thông người dùng thao tác, filter để xác thực người dùng sử dụng api
     *
     * @param request chưa thông tin gửi từ client về
     * @return
     */
    public Customer getCustomerByToken(HttpServletRequest request){
        String token = request.getHeader("token"); // lấy token
        if(token != null && jwtUtils.validateJwtToken(token)){ // check token có null hoặc là sai định dạng hay không
            String username = jwtUtils.getUserNameFromJwtToken(token); // lấy ra username từ token
            System.out.println(username);
            Customer customer = customerRepository.getCustomerByUsername(username); // lấy ra user từ db theo username giải mã được từ token
            return customer;
        }
        return null;
    }
}
