package com.aoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aoa.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
