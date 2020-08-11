package com.domaranskiy.models.message;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {
    private String author;
    private String messageBody;
    private MessageStatus status;

    public Message(String author, String messageBody) {
        this.author = author;
        this.messageBody = messageBody;
        this.status = MessageStatus.NOT_READ;
    }



}
