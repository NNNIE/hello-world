package com.nadeen.helloworld;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class Main {


  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }

  @Bean
  CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
    return args -> {
      Customer nad = new Customer("Nadeen", "nad@gmail.com", 27, java.time.LocalDate.now());
      customerRepository.save(nad);
    };
  }



}
