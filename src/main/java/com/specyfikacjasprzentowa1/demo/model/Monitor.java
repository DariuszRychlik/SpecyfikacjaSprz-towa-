package com.specyfikacjasprzentowa1.demo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(of = ("id"))
@Entity
public class Monitor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ekran;
    private String czasReakcjiMatrycy;
    private String czestotliwoscOdswiezaniaEkranu;
    private String zlacza;

    @ManyToMany
    private Set<Computer> computers = new HashSet<>();

    public Monitor(){
    }

    public Monitor(String ekran, String czasReakcjiMatrycy, String czestotliwoscOdswiezaniaEkranu,String zlacza) {
        this.ekran = ekran;
        this.czasReakcjiMatrycy = czasReakcjiMatrycy;
        this.czestotliwoscOdswiezaniaEkranu = czestotliwoscOdswiezaniaEkranu;
        this.zlacza = zlacza;
    }
}
