package com.samsung.repository;

import com.samsung.domain.Importance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImportanceRepository extends JpaRepository<Importance, Integer> {

    Importance findByName(String name);
}
