package de.neofonie.techly.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import de.neofonie.techly.graphql.persistence.model.Author;
import de.neofonie.techly.graphql.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AuthorQuery implements GraphQLQueryResolver {

    @Autowired
    private AuthorService authorService;

    public List<Author> getAuthors(final int count) {
        return authorService.getAuthors(count);
    }

    public Optional<Author> getAuthor(final int id) {
        return authorService.getAuthor(id);
    }
}
