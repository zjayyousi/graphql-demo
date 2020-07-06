package de.neofonie.techly.graphql.persistence.repository;

import de.neofonie.techly.graphql.persistence.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
