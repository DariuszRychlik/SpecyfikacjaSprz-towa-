package com.specyfikacjasprzentowa1.demo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(of =  {"id"})
@Entity
public class Mouse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String typMyszy;
    private String czuloscMyszy;
    private String typPodlaczenia;
    private String liczbaPrzyciskow;

    @ManyToMany
    private Set<Mouse> mouses = new HashSet<>();

    public Mouse() {
    }

    public Mouse(String typMyszy, String czuloscMyszy, String typPodlaczenia, String liczbaPrzyciskow) {
        this.typMyszy = typMyszy;
        this.czuloscMyszy = czuloscMyszy;
        this.typPodlaczenia = typPodlaczenia;
        this.liczbaPrzyciskow = liczbaPrzyciskow;
    }
}
