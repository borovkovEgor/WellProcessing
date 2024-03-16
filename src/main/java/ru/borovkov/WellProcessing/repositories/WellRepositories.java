package ru.borovkov.WellProcessing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.borovkov.WellProcessing.models.Well;

import java.util.Optional;

@Repository
public interface WellRepositories extends JpaRepository<Well, String> {
    Optional<Well> findByNumber(String number);
}
