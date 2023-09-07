package com.example.message_board.service;


import com.example.message_board.dao.MessageRepository;
import com.example.message_board.model.Messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Messages> getAllMessages() {
        return messageRepository.findAll();
    }

    public Messages getMessageById(Long id) {
        return messageRepository.findById(id).orElse(null);
    }

    public Messages saveMessage(Messages message) {
        return messageRepository.save(message);
    }

    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);
    }
}

