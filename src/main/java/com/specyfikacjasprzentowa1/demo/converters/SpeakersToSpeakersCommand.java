package com.specyfikacjasprzentowa1.demo.converters;

import com.specyfikacjasprzentowa1.demo.command.SpeakersCommand;
import com.specyfikacjasprzentowa1.demo.model.Speakers;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class SpeakersToSpeakersCommand implements Converter<Speakers, SpeakersCommand> {

    @Synchronized
    @Nullable
    @Override
    public SpeakersCommand convert(Speakers source) {
        if (source == null) {
            return null;
        }

        final SpeakersCommand speakersCommand = new SpeakersCommand();
        speakersCommand.setTypZestawu(source.getTypZestawu());
        speakersCommand.setMocGlosnikow(source.getMocGlosnikow());
        speakersCommand.setTypPodlaczenia(source.getTypPodlaczenia());
        speakersCommand.setNazwaProducenta(source.getNazwaProducenta());

        return speakersCommand;
    }
}
