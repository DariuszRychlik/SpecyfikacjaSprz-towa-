package com.specyfikacjasprzentowa1.demo.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Setter

public class ComputerCommand {
    private Long id;
    private String procesor;
    private String kartaGraficzna;
    private String pamiencRam;
    private String pojemnoscDysku;
}
