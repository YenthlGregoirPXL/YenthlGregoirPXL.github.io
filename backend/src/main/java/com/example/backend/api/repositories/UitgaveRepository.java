package com.example.backend.api.repositories;

import com.example.backend.api.models.Uitgave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UitgaveRepository extends JpaRepository<Uitgave, Long> {

}
