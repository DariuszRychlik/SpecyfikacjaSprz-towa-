package com.specyfikacjasprzentowa1.demo.repositories;

import com.specyfikacjasprzentowa1.demo.model.Computer;
import com.specyfikacjasprzentowa1.demo.model.Monitor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MonitorRepository extends CrudRepository<Monitor, Long> {
    Optional<Monitor> getAllByComputersIsContaining(Computer procesor);

}
