package com.nadeen.helloworld;
import java.time.LocalDate;

public record CustomerRequest(String name, String email, Integer age, LocalDate created_at) {
    
}
