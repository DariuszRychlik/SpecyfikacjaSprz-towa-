package com.specyfikacjasprzentowa1.demo.converters;

import com.specyfikacjasprzentowa1.demo.command.MonitorCommand;
import com.specyfikacjasprzentowa1.demo.model.Monitor;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class MonitorCommandToMonitor implements Converter<MonitorCommand, Monitor> {

    @Synchronized
    @Nullable
    @Override
    public Monitor convert(MonitorCommand source) {
        if (source == null) {
            return null;
        }

        final Monitor monitor = new Monitor();
        monitor.setEkran(source.getEkran());
        monitor.setCzasReakcjiMatrycy(source.getCzasReakcjiMatrycy());
        monitor.setCzestotliwoscOdswiezaniaEkranu(source.getCzestotliwoscOdswiezaniaEkranu());
        monitor.setZlacza(source.getZlacza());

        return monitor;
    }
}
