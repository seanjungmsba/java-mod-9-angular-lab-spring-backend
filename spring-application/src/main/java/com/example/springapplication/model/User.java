package com.example.springapplication.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class User {
    private String firstName;
    private Boolean isOnline;
}