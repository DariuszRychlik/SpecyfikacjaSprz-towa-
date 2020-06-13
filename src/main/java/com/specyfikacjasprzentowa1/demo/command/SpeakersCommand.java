package com.specyfikacjasprzentowa1.demo.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Setter
public class SpeakersCommand {
    private Long id;
    private String typZestawu;
    private String mocGlosnikow;
    private String typPodlaczenia;
    private String nazwaProducenta;

}
