package com.example.message_board.controller;

import com.example.message_board.dao.MessageRepository;
import com.example.message_board.model.Messages;
import com.example.message_board.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/messages")
    public String getAllMessages(Model model) {
        List<Messages> messages = messageService.getAllMessages();
        model.addAttribute("messages", messages);
        return "messageboard";  // This is the name of the Thymeleaf template
    }

    @ResponseBody
    @GetMapping("/api/messages")
    public List<Messages> fetchAllMessages() {
        return messageService.getAllMessages();
    }

    @ResponseBody
    @GetMapping("/api/messages/{id}")
    public Messages getMessageById(@PathVariable Long id) {
        return messageService.getMessageById(id);
    }

    @ResponseBody
    @PostMapping("/api/messages")
    public Messages createMessage(@RequestBody Messages messages) {
        return messageService.saveMessage(messages);
    }

    @ResponseBody
    @PutMapping("/api/messages/{id}")
    public Messages updateMessage(@PathVariable Long id, @RequestBody Messages messages) {
        return messageService.saveMessage(messages);
    }

    @ResponseBody
    @DeleteMapping("/api/messages/{id}")
    public void deleteMessage(@PathVariable Long id) {
        messageService.deleteMessage(id);
    }
}
