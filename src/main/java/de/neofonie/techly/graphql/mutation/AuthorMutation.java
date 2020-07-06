package de.neofonie.techly.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import de.neofonie.techly.graphql.persistence.model.Author;
import de.neofonie.techly.graphql.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorMutation implements GraphQLMutationResolver {

    @Autowired
    private AuthorService authorService;

    public Author createAuthor(String name) {
        return authorService.creatAuthor(name);
    }

}
