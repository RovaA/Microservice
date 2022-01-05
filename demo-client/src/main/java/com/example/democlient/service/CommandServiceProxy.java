package com.example.democlient.service;

import com.example.democlient.domain.Command;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient("demo-payment")
public interface CommandServiceProxy {

    @GetMapping("/api/commands")
    List<Command> findCommands();

    @PostMapping("/api/commands")
    void saveCommands(List<? extends Command> commands);

}
