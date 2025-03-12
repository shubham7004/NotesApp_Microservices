package com.optxt.notesapp.notesapp.client;

import com.optxt.notesapp.notesapp.dto.UserDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "user-service", url = "http://localhost:8200")
public interface UserClient {

    @GetMapping("/api/users/{id}")
    @CircuitBreaker(name = "userClient", fallbackMethod = "getUserByUserIDFallback")
    UserDTO getUserById(@PathVariable long id);

    default List<UserDTO> getUserByUserIDFallback(Exception e) {
        System.err.println(e.getMessage());
        return List.of();
    }

}
