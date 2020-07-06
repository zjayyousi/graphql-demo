package de.neofonie.techly.graphql.service;

import de.neofonie.techly.graphql.persistence.model.Post;
import de.neofonie.techly.graphql.persistence.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional(readOnly = true)
    public List<Post> getPosts() {
        return this.postRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Post> getPost(int id) {
        return postRepository.findById(id);
    }

}
