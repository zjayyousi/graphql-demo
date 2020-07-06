package de.neofonie.techly.graphql.service;

import de.neofonie.techly.graphql.persistence.model.Comment;
import de.neofonie.techly.graphql.persistence.model.Post;
import de.neofonie.techly.graphql.persistence.repository.CommentRepository;
import de.neofonie.techly.graphql.persistence.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Transactional(readOnly = true)
    public List<Comment> getComments() {
        return this.commentRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Comment> getComment(int id) {
        return commentRepository.findById(id);
    }

    public Comment updateComment(int id, String content) throws Exception {
        Optional<Comment> commentOptional = commentRepository.findById(id);
        if (commentOptional.isPresent()) {
            Comment comment = commentOptional.get();
            comment.setContent(content);
            return commentRepository.save(comment);
        } else {
            throw new Exception("Comment not found");
        }
    }

    public Comment createComment(int post_id, String content) throws Exception {
        Optional<Post> postOptional = postRepository.findById(post_id);
        if (postOptional.isPresent()) {
            Post post = postOptional.get();
            Comment comment = new Comment();
            comment.setContent(content);
            comment.setPost(post);
            comment.setCreated(new Date());
            return commentRepository.save(comment);
        } else {
            throw new Exception("Post not found");
        }
    }

}
