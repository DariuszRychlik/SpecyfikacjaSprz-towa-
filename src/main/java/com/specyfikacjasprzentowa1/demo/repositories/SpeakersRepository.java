package com.specyfikacjasprzentowa1.demo.repositories;

import com.specyfikacjasprzentowa1.demo.model.Speakers;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SpeakersRepository extends CrudRepository<Speakers, Long> {
    Optional<Speakers> getSpeakersByTypZestawu(String typZestawu);

}
