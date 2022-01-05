package com.example.demopayment.controller;

import com.example.demopayment.domain.Command;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class CommandController {

    @GetMapping("/api/commands")
    public List<Command> findCommands() {
        ArrayList<Command> commands = new ArrayList<>();
        Command command = new Command();
        command.setName("Command 1");
        commands.add(command);
        return commands;
    }

    @PostMapping("/api/commands")
    public Command sendCommands() {
        return new Command();
    }

    @RabbitListener(queues = "AMPQ")
    public void listen(String message) {
        log.info("Message read from AMPQ : " + message);
    }
}
