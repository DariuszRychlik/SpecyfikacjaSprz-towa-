package com.specyfikacjasprzentowa1.demo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(of =  {"id"})
@Entity
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String procesor;
    private String kartaGraficzna;
    private String pamiencRam;
    private String pojemnoscDysku;

    @ManyToMany(mappedBy = "computers")
    private Set<Monitor> monitors = new HashSet<>();
    //private Set<Mouse> mouses = new HashSet<>();
    //private Set<Speakers> speakerss = new HashSet<>();


    public Computer() {
    }
    public Computer(String procesor, String kartaGraficzna, String pamiencRam, String pojemnoscDysku) {
        this.procesor = procesor;
        this.kartaGraficzna = kartaGraficzna;
        this.pamiencRam = pamiencRam;
        this.pojemnoscDysku = pojemnoscDysku;
    }
}
