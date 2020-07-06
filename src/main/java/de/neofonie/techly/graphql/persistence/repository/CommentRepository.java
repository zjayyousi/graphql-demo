package de.neofonie.techly.graphql.persistence.repository;

import de.neofonie.techly.graphql.persistence.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
