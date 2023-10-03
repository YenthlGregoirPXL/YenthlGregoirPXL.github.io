package com.example.backend.api.repositories;

import com.example.backend.api.models.Speeldag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeeldagRepository extends JpaRepository<Speeldag, Long> {
}
