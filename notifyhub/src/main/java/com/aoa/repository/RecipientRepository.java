package com.aoa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aoa.entities.Recipient;

public interface RecipientRepository extends JpaRepository<Recipient, Long>{

	List<Recipient> findByName(String name);
	
	List<Recipient> findByNameContaining(String keyword);
	
	List<Recipient> findByNameContainingIgnoreCase(String name);


}
