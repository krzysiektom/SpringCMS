package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class AuthorConverter implements Converter<String, Author> {
    @Autowired
    AuthorRepository authorRepository;
    @Override
    public Author convert(String strings) {
        return authorRepository.getById(Long.parseLong(strings));
    }
}