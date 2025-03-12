package com.optxt.notesapp.userservice.repository;

import com.optxt.notesapp.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
