package de.neofonie.techly.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import de.neofonie.techly.graphql.persistence.model.Comment;
import de.neofonie.techly.graphql.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CommentQuery implements GraphQLQueryResolver {

    @Autowired
    private CommentService commentService;

    public List<Comment> getComments() {
        return commentService.getComments();
    }

    public Optional<Comment> getComment(final int id) {
        return commentService.getComment(id);
    }

}
