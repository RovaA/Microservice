package com.example.democlient.batch;

import com.example.democlient.domain.Command;
import com.example.democlient.service.CommandServiceProxy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class CommandWriter implements ItemWriter<Command> {

    @Autowired
    private CommandServiceProxy commandServiceProxy;

    @Override
    public void write(List<? extends Command> list) {
        list.forEach(command -> {
            log.info("will be saved {}", command);
        });
        commandServiceProxy.saveCommands(list);
    }
}
