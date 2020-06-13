package com.specyfikacjasprzentowa1.demo.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Setter

public class MonitorCommand {
    private Long id;
    private String ekran;
    private String czasReakcjiMatrycy;
    private String czestotliwoscOdswiezaniaEkranu;
    private String zlacza;
}
