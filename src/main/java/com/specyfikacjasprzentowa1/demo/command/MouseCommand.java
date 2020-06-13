package com.specyfikacjasprzentowa1.demo.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Setter
public class MouseCommand {
    private Long id;
    private String typMyszy;
    private String czuloscMyszy;
    private String typPodlaczenia;
    private String liczbaPrzyciskow;
}
