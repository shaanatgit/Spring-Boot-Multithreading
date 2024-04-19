package com.demo.multithreading.executor.api.repo;

import com.demo.multithreading.executor.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
