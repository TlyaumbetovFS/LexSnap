package dev.lexsnap.repository;

import dev.lexsnap.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepository extends JpaRepository<Word, Long> {
}
