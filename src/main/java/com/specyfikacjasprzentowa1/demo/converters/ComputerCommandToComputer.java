package com.specyfikacjasprzentowa1.demo.converters;

import com.specyfikacjasprzentowa1.demo.command.ComputerCommand;
import com.specyfikacjasprzentowa1.demo.model.Computer;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class ComputerCommandToComputer implements Converter<ComputerCommand, Computer> {

    @Synchronized
    @Nullable
    @Override
    public Computer convert(ComputerCommand source) {
        if (source == null) {
            return null;
        }

        final Computer computer = new Computer();
        computer.setProcesor(source.getProcesor());
        computer.setKartaGraficzna(source.getKartaGraficzna());
        computer.setPamiencRam(source.getPamiencRam());
        computer.setPojemnoscDysku(source.getPojemnoscDysku());

        return computer;
    }


}
