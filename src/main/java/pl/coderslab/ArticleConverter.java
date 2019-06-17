package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class ArticleConverter implements Converter<String, Article> {
    @Autowired
    ArticleRepository articleRepository;

    @Override
    public Article convert(String strings) {
        return articleRepository.getById(Long.parseLong(strings));
    }
}
