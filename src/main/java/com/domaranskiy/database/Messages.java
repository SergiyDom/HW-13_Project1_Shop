package com.domaranskiy.database;

import com.domaranskiy.models.message.Message;

import java.util.ArrayList;
import java.util.List;

public class Messages {
    private static Messages instance;
    private static List<Message> messages = new ArrayList<>();

    static {
        messages.add(new Message("Sergiy", "test message to admin"));
        messages.add(new Message("Ruslan", "test message to admin"));
    }

    public Messages() {
    }

    public synchronized static Messages getInstance(){
        if (instance == null){
            instance = new Messages();
        }
        return instance;
    }

    public static void addMessage(Message message){
        messages.add(message);
    }

    public static List<Message> getMessages(){
        return messages;
    }
}
