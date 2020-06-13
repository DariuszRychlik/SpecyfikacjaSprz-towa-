package com.specyfikacjasprzentowa1.demo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(of = ("id"))
@Entity
public class Speakers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String typZestawu;
    private String mocGlosnikow;
    private String typPodlaczenia;
    private String nazwaProducenta;

    @ManyToMany
    private Set<Mouse> mouses = new HashSet<>();

    public Speakers(){
    }

    public Speakers(String typZestawu, String mocGlosnikow, String typPodlaczenia,String nazwaProducenta) {
        this.typZestawu = typZestawu;
        this.mocGlosnikow = mocGlosnikow;
        this.typPodlaczenia = typPodlaczenia;
        this.nazwaProducenta = nazwaProducenta;
    }
}
