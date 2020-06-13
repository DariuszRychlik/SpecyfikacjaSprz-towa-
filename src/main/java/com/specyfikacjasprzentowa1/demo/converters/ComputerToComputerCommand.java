package com.specyfikacjasprzentowa1.demo.converters;

import com.specyfikacjasprzentowa1.demo.command.ComputerCommand;
import com.specyfikacjasprzentowa1.demo.model.Computer;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class ComputerToComputerCommand implements Converter<Computer, ComputerCommand> {

    @Synchronized
    @Nullable
    @Override
    public ComputerCommand convert(Computer source) {
        if (source == null) {
            return null;
        }

        final ComputerCommand computerCommand = new ComputerCommand();
        computerCommand.setProcesor(source.getProcesor());
        computerCommand.setKartaGraficzna(source.getKartaGraficzna());
        computerCommand.setPamiencRam(source.getPamiencRam());
        computerCommand.setPojemnoscDysku(source.getPojemnoscDysku());

        return computerCommand;
    }
}
