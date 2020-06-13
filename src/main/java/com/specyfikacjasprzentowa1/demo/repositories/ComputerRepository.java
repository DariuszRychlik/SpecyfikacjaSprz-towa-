package com.specyfikacjasprzentowa1.demo.repositories;

import com.specyfikacjasprzentowa1.demo.model.Computer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ComputerRepository extends CrudRepository<Computer, Long> {
    Optional<Computer> getFirstByProcesorAndKartaGraficzna(String procesor, String kartaGraficzna);
}
