package com.example.springapplication.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Message {
    public User user;
    public String text;
    public int conversationId;
    public int sequenceNumber;
}
