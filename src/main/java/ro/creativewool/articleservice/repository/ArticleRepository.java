package ro.creativewool.articleservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ro.creativewool.articleservice.entity.Article;

@Repository
public interface ArticleRepository extends MongoRepository<Article, String> {

}
