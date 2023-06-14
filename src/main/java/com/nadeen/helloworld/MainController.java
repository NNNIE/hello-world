package com.nadeen.helloworld;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("api/v1/customer")
public class MainController {
  // https://spring.io/guides/gs/accessing-data-mysql/
  private final CustomerRepository customerRepository;

  public MainController(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @GetMapping("/all")
  public List<Customer> getCustomer() {
    return customerRepository.findAll();
  }

  @GetMapping("{customerName}")
  public Customer getCustomerByName(@PathVariable("customerName") String name){
    return customerRepository.findCustomerByNameNative(name);
  }

  @GetMapping
  public List<Customer> getCustomerByAge25Native(@RequestParam Integer age){
    return customerRepository.findCustomerByAge25Native(age);
  }

  @PostMapping
  public void addCustomer(@RequestBody CustomerRequest custReq) {
    Customer c = new Customer();
    c.setEmail(custReq.email());
    c.setName(custReq.name());
    c.setAge(custReq.age());
    c.setCreatedAt(java.time.LocalDate.now());
    customerRepository.save(c);
  }

  @DeleteMapping("{customerId}")
  public void deleteCustomer(@PathVariable("customerId") Integer id){
    customerRepository.deleteById(id);
  }
  
  @PutMapping("{customerId}")
  public void updateCustomer(@PathVariable("customerId") Integer id, @RequestBody CustomerRequest custReq){
    
    Customer mycust = customerRepository.findById(id).get();
    mycust.setEmail(custReq.email());
    mycust.setName(custReq.name());
    mycust.setAge(custReq.age());
    customerRepository.save(mycust);
  }


}
