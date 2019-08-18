package ro.creativewool.articleservice.service;

import org.springframework.stereotype.Service;
import ro.creativewool.articleservice.entity.Article;
import ro.creativewool.articleservice.exception.BadRequestException;
import ro.creativewool.articleservice.exception.NotFoundException;
import ro.creativewool.articleservice.repository.ArticleRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Article setData(String id, String body) {
        final Article article = articleRepository
                .findById(id)
                .orElseThrow(NotFoundException::new);

        article.setUpdated ( LocalDateTime.now () );
        article.setBody(body);

        return articleRepository.save(article);
    }

    public Article findById(String id) {
        return articleRepository
                .findById(id)
               .orElseThrow( NotFoundException::new);

    }

    public Article save(Article newArticle) {
        if (isNewAArticleValid(newArticle)) {

            newArticle.setCreated ( LocalDateTime.now () );
            newArticle.setUpdated ( LocalDateTime.now () );

            return articleRepository.save(newArticle);
        }
        throw new BadRequestException ();
    }

    private boolean isNewAArticleValid(Article article) {
        return article.getAuthor() != null && article.getAuthor().replaceAll(" ","").length () > 0;
    }

}
