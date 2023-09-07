package com.example.message_board.dao;


import com.example.message_board.model.Messages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Messages, Long> {
}

