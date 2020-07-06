package de.neofonie.techly.graphql.persistence.repository;

import de.neofonie.techly.graphql.persistence.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
