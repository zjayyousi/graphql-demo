package de.neofonie.techly.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import de.neofonie.techly.graphql.persistence.model.Comment;
import de.neofonie.techly.graphql.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentMutation implements GraphQLMutationResolver {

    @Autowired
    private CommentService commentService;

    public Comment createComment(int post_id, String content) throws Exception {
        return commentService.createComment(post_id, content);
    }

    public Comment updateComment(int id, String content) throws Exception {
        return commentService.updateComment(id, content);
    }

}
