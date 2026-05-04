package com.coditas.learninganddevelopementservice.repository;

import com.coditas.learninganddevelopementservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
