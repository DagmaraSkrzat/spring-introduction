package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {

    final private MessagePrinter service;

    @Autowired
    public MessagePrinter(MessagePrinter service) {
        this.service = service;
    }

    public void printMessage() {
    }
}