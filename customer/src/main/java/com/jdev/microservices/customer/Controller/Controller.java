package com.jdev.microservices.customer.Controller;

import com.jdev.microservices.customer.Component.Register;
import com.jdev.microservices.customer.Entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired Register register;

    @PostMapping("/register")
    public Customer register(@RequestBody Customer customer){
        return register.register(customer);
    }


}
