package de.neofonie.techly.graphql.service;

import de.neofonie.techly.graphql.persistence.model.Author;
import de.neofonie.techly.graphql.persistence.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Transactional(readOnly = true)
    public List<Author> getAuthors(int count) {
        return this.authorRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<Author> getAuthor(int id) {
        return authorRepository.findById(id);
    }

    public Author creatAuthor(String name) {
        Author author = new Author();
        author.setName(name);
        return authorRepository.save(author);
    }

}
