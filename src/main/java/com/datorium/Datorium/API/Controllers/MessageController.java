// In message controller, create an endpoint, which uses both MessageService and Message.java

package com.datorium.Datorium.API.Controllers;

import com.datorium.Datorium.API.DTOs.Message;
import com.datorium.Datorium.API.Services.MessageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/message")

public class MessageController {

    private MessageService messageService;

    public MessageController() {
        messageService = new MessageService();
    }

    @PostMapping("/message")
    public String message(@RequestBody Message message) {
        return messageService.sendMessage(message);
    }
}
