package com.nadeen.helloworld;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    

  @Query(value = "SELECT * FROM customer WHERE customer_name= :name", nativeQuery = true) 
  Customer findCustomerByNameNative(@PathVariable("name") String name);

  @Query(value = "SELECT * FROM customer WHERE age >= :age", nativeQuery = true) 
  List<Customer> findCustomerByAge25Native(@RequestParam("age") Integer age);

}
