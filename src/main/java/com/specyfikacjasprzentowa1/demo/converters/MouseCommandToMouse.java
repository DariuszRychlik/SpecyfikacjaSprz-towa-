package com.specyfikacjasprzentowa1.demo.converters;

import com.specyfikacjasprzentowa1.demo.command.MouseCommand;
import com.specyfikacjasprzentowa1.demo.model.Mouse;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class MouseCommandToMouse implements Converter<MouseCommand, Mouse> {


    @Synchronized
    @Nullable
    @Override
    public Mouse convert(MouseCommand source) {
        if (source == null) {
            return null;
        }

        final Mouse mouse = new Mouse();
        mouse.setTypMyszy(source.getTypMyszy());
        mouse.setCzuloscMyszy(source.getCzuloscMyszy());
        mouse.setTypPodlaczenia(source.getTypPodlaczenia());
        mouse.setLiczbaPrzyciskow(source.getLiczbaPrzyciskow());

        return mouse;
    }
}
