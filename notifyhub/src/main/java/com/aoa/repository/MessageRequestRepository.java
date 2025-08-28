package com.aoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aoa.entities.MessageRequest;

public interface MessageRequestRepository extends JpaRepository<MessageRequest, Long> {

}
