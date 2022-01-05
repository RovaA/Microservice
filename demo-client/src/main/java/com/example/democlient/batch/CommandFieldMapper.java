package com.example.democlient.batch;

import com.example.democlient.domain.Command;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class CommandFieldMapper implements FieldSetMapper<Command> {

    @Override
    public Command mapFieldSet(FieldSet fieldSet) throws BindException {
        Command command = new Command();
        return command;
    }
}
