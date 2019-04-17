package com.jdev.microservices.customer.Repository;

import com.jdev.microservices.customer.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface Repository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByName(@Param("name") String name);
}
