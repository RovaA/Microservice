package com.example.democlient.batch;

import com.example.democlient.domain.Command;
import org.springframework.batch.item.ItemProcessor;

public class CommandProcessor implements ItemProcessor<Command, Command> {

    @Override
    public Command process(Command command) {
        return command;
    }
}
