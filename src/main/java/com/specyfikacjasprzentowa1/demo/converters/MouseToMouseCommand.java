package com.specyfikacjasprzentowa1.demo.converters;

import com.specyfikacjasprzentowa1.demo.command.MouseCommand;
import com.specyfikacjasprzentowa1.demo.model.Mouse;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class MouseToMouseCommand implements Converter<Mouse, MouseCommand> {


    @Synchronized
    @Nullable
    @Override
    public MouseCommand convert(Mouse source) {
        if (source == null) {
            return null;
        }

        final MouseCommand mouseCommand = new MouseCommand();
        mouseCommand.setTypMyszy(source.getTypMyszy());
        mouseCommand.setCzuloscMyszy(source.getCzuloscMyszy());
        mouseCommand.setTypPodlaczenia(source.getTypPodlaczenia());
        mouseCommand.setLiczbaPrzyciskow(source.getLiczbaPrzyciskow());

        return mouseCommand;
    }
}
