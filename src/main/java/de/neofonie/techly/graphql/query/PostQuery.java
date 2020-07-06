package de.neofonie.techly.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import de.neofonie.techly.graphql.persistence.model.Post;
import de.neofonie.techly.graphql.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PostQuery implements GraphQLQueryResolver {

    @Autowired
    private PostService postService;

    public List<Post> getPosts() {
        return postService.getPosts();
    }

    public Optional<Post> getPost(final int id) {
        return postService.getPost(id);
    }

}
