package com.specyfikacjasprzentowa1.demo.converters;

import com.specyfikacjasprzentowa1.demo.command.SpeakersCommand;
import com.specyfikacjasprzentowa1.demo.model.Speakers;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class SpeakersCommandToSpeakers implements Converter<SpeakersCommand, Speakers> {

    @Synchronized
    @Nullable
    @Override
    public Speakers convert(SpeakersCommand source) {
        if (source == null) {
            return null;
        }

        final Speakers speakers = new Speakers();
        speakers.setTypZestawu(source.getTypZestawu());
        speakers.setMocGlosnikow(source.getMocGlosnikow());
        speakers.setTypPodlaczenia(source.getTypPodlaczenia());
        speakers.setNazwaProducenta(source.getNazwaProducenta());

        return speakers;
    }
}
