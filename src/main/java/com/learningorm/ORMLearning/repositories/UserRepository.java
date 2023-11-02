package com.learningorm.ORMLearning.repositories;

import com.learningorm.ORMLearning.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
