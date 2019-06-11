package com.netcracker.blogproject.services;

import com.netcracker.blogproject.entities.Article;
import com.netcracker.blogproject.entities.Topic;
import com.netcracker.blogproject.repositories.ArticleRepository;
import com.netcracker.blogproject.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private TopicRepository userRepository;

    public List<Article> getAllArticles(int topicId) {
        List<Article> articles = null;
        articles = new ArrayList<>();
        Iterable<Article> allArticles = articleRepository.findAll();
        for (Article article : allArticles) {
            if (article.getArticleTopic().getTopicId() == topicId) {
                articles.add(article);
            }
        }
        return articles;
    }

    public Article getArticleById(int topicId, int articleId) {
        Article article = articleRepository.findById(articleId).get();
            if (topicId != article.getArticleTopic().getTopicId()) {
                article = null;
            }
        return article;
    }

    public boolean addArticle(int topicId, Article article) {
        if (topicRepository.existsById(topicId) && !articleRepository.existsById(article.getArticleId())) {
            if (topicRepository.findById(topicId).get().equals(article.getArticleTopic())) {
                articleRepository.save(article);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void editArticleById(int topicId, int articleId, Article article) {
        if (topicRepository.existsById(topicId) && articleRepository.existsById(article.getArticleId())) {
            if (topicRepository.findById(topicId).get().equals(article.getArticleTopic()) &&
                    article.getArticleId() == articleId) {
                articleRepository.save(article);
            }
        }
    }

    public void deleteAllArticles(int topicId) {
        Iterable<Article> allArticles = articleRepository.findAll();
        for (Article article : allArticles) {
            if (article.getArticleTopic().getTopicId() == topicId) {
                articleRepository.deleteById(article.getArticleId());
            }
        }
    }

    public void deleteArticleById(int topicId, int articleId) {
        if (articleRepository.existsById(articleId)) {
            if (articleRepository.findById(articleId).get().getArticleTopic().getTopicId() == topicId) {
                articleRepository.deleteById(articleId);
            }
        }
    }

}