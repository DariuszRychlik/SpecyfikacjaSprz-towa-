package com.specyfikacjasprzentowa1.demo.converters;

import com.specyfikacjasprzentowa1.demo.command.MonitorCommand;
import com.specyfikacjasprzentowa1.demo.model.Monitor;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class MonitorToMonitorCommand implements Converter<Monitor, MonitorCommand> {

    @Synchronized
    @Nullable
    @Override
    public MonitorCommand convert(Monitor source) {
        if (source == null) {
            return null;
        }

        final MonitorCommand monitorCommand = new MonitorCommand();
        monitorCommand.setEkran(source.getEkran());
        monitorCommand.setCzasReakcjiMatrycy(source.getCzasReakcjiMatrycy());
        monitorCommand.setCzestotliwoscOdswiezaniaEkranu(source.getCzestotliwoscOdswiezaniaEkranu());
        monitorCommand.setZlacza(source.getZlacza());

        return monitorCommand;
    }
}
