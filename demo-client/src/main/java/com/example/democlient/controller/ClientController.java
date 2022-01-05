package com.example.democlient.controller;

import com.example.democlient.domain.Command;
import com.example.democlient.service.CommandServiceProxy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Controller
public class ClientController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private CommandServiceProxy commandServiceProxy;

    @GetMapping
    public String home(Model model) {
        List<Command> commands = commandServiceProxy.findCommands();
        log.info("Command size {}", commands.size());
        model.addAttribute(commands);
        rabbitTemplate.convertAndSend("AMPQ", "De la part du client");
        return "home";
    }

    @GetMapping("sendMessage")
    public String sendMessage() {
        return "";
    }

}
