package com.jdev.microservices.customer.Component;

import com.jdev.microservices.customer.Entity.Customer;
import com.jdev.microservices.customer.Repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Lazy
public class Register {
    Repository customerRespository;
    @Autowired Sender sender;

    @Autowired
   public Register(Repository customerRespository, Sender sender){
        this.customerRespository = customerRespository;
        this.sender = sender;
    }

    public Customer register(Customer customer){
        Optional<Customer> existingCustomer =
                customerRespository.findByName(customer.getName());

        if (existingCustomer.isPresent()){
            throw new RuntimeException("is already exists");
        } else {
            customerRespository.save(customer);
            sender.send(customer.getEmail());
        }
        return customer;
    }
}
