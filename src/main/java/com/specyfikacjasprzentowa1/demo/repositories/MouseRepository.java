package com.specyfikacjasprzentowa1.demo.repositories;

import com.specyfikacjasprzentowa1.demo.model.Mouse;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MouseRepository extends CrudRepository<Mouse, Long> {
    Optional<Mouse> getFirstByTypMyszyAndCzuloscMyszy(String myszy, String typMyszy);
}
