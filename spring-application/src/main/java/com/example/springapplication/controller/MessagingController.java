package com.example.springapplication.controller;

import com.example.springapplication.model.Message;
import com.example.springapplication.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
@Slf4j
public class MessagingController {

    List<Message> userMessages = new ArrayList<Message>();
    List<Message> senderMessages = new ArrayList<Message>();

    @PostConstruct
    private void initMessages() {
        userMessages.add(
                new Message(
                        new User("Aurelie", true),
                        "Message from Lilly",
                        1, 2
                )
        );

        senderMessages.add(
                new Message(
                        new User("Ludovic", true),
                        "Message from Ludo",
                        1, 0
                )
        );
        senderMessages.add(
                new Message(
                        new User("Jessica", false),
                        "Message from Jess",
                        1, 1
                )
        );

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/api/get-user-messages")
    public List<Message> getUserMessages() {
        return userMessages;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/api/get-sender-messages")
    public List<Message> getSenderMessages() {
        return senderMessages;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/add-user-message")
    public List<Message> addUserMessage(@RequestBody Message newMessage) {
        userMessages.add(newMessage);
        return userMessages;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/api/conversations/{conversationId}/{sequenceId}")
    public List<Message> DeleteUserMessage(@PathVariable long conversationId, @PathVariable long sequenceId) {
        userMessages.removeIf(message -> (message.conversationId == conversationId && message.sequenceNumber == sequenceId));
        return this.userMessages;
    }

}
