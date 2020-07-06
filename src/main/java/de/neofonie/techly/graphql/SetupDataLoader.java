package de.neofonie.techly.graphql;

import de.neofonie.techly.graphql.persistence.model.Author;
import de.neofonie.techly.graphql.persistence.model.Comment;
import de.neofonie.techly.graphql.persistence.model.Post;
import de.neofonie.techly.graphql.persistence.repository.AuthorRepository;
import de.neofonie.techly.graphql.persistence.repository.CommentRepository;
import de.neofonie.techly.graphql.persistence.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger log = LoggerFactory.getLogger(SetupDataLoader.class);

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Override
    @Transactional
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        createData();
    }

    @Transactional
    void createData() {
        // load authors
        Author author_1 = createAuthor("Ziad El-Jayyousi");
        Author author_2 = createAuthor("Andreas Volk");
        Author author_3 = createAuthor("Marcin Bak");

        // load posts and comments
        Post post_1 = createPost(author_1, "Another Day in Paradise", "Another Day in Paradise, is a song recorded by English drummer and singer-songwriter Phil Collins");
        createComment(post_1, "Nice song, I really like it!");
        createComment(post_1, "Nah, I am a techno Monkey...");
        createComment(post_1, "Country Music anyone!!");

        Post post_2 = createPost(author_2, "I Want To Break Free", "TIL MTV banned Queen from their US network because of the, I Want To Break Free, music video. Yes we banned Queen videos from playing because of Freddie's transvestism. We were wrong.");
        createComment(post_2, "Wow, why so mean!");
        createComment(post_2, "I love Freddy");
        createComment(post_2, "I AM A QUEEN!");
    }

    private Author createAuthor(String name) {
        Author author = new Author();
        author.setName(name);
        return authorRepository.save(author);
    }

    private Post createPost(Author author, String title, String content) {
        Post post = new Post();
        post.setAuthor(author);
        post.setTitle(title);
        post.setContent(content);
        post.setCreated(new Date());
        return postRepository.save(post);
    }

    private void createComment(Post post, String content) {
        Comment comment = new Comment();
        comment.setPost(post);
        comment.setContent(content);
        comment.setCreated(new Date());
        commentRepository.save(comment);
    }

}
