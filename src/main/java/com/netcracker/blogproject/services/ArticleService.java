package com.netcracker.blogproject.services;

import com.netcracker.blogproject.entities.Article;
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

    public List<Article> getAllArticles(String topicId) {
        Integer topicIdInt = null;
        List<Article> articles = null;
        try {
            topicIdInt = Integer.parseInt(topicId);
            articles = new ArrayList<>();
            Iterable<Article> allArt = articleRepository.findAll();
            for(Article a : allArt) {
                if(a.getArticleTopic().getTopicId() == topicIdInt) {
                    articles.add(a);
                }
            }
        } catch (NumberFormatException eNF) {
            //
        }
        return articles;
    }

    public Article getArticleById(String topicId, String articleId) {
        Integer topicIdInt = null;
        Integer articleIdInt = null;
        Article article = null;
        try {
            topicIdInt = Integer.parseInt(topicId);
            articleIdInt = Integer.parseInt(articleId);
            article = articleRepository.findById(articleIdInt).get();
            if(topicIdInt != article.getArticleTopic().getTopicId()) {
                article = null;
            }
        } catch (NumberFormatException eNF) {
            //
        }
        return article;
    }

    public void addArticle(String topicId, Article article) {
        Integer topicIdInt = null;
        try {
            topicIdInt = Integer.parseInt(topicId);
            if(topicRepository.existsById(topicIdInt) && !articleRepository.existsById(article.getArticleId())) {
                if(topicRepository.findById(topicIdInt).get().equals(article.getArticleTopic())) {
                    articleRepository.save(article);
                }
            }
        } catch (NumberFormatException eNF) {
            //
        }
    }

    public void editArticleById(String topicId, String articleId, Article article) {
        Integer topicIdInt = null;
        Integer articleIdInt = null;
        try {
            topicIdInt = Integer.parseInt(topicId);
            articleIdInt = Integer.parseInt(articleId);
            if(topicRepository.existsById(topicIdInt) && articleRepository.existsById(article.getArticleId())) {
                if(topicRepository.findById(topicIdInt).get().equals(article.getArticleTopic()) &&
                        article.getArticleId() == articleIdInt) {
                    articleRepository.save(article);
                }
            }
        } catch (NumberFormatException eNF) {
            //
        }
    }

    public void deleteAllArticles(String topicId) {
        Integer topicIdInt;
        try {
            topicIdInt = Integer.parseInt(topicId);
            Iterable<Article> allArt = articleRepository.findAll();
            for(Article a : allArt) {
                if(a.getArticleTopic().getTopicId() == topicIdInt) {
                    articleRepository.deleteById(a.getArticleId());
                }
            }
        } catch (NumberFormatException eNF) {
            //
        }
    }

    public void deleteArticleById(String topicId, String articleId) {
        Integer topicIdInt;
        try {
            topicIdInt = Integer.parseInt(topicId);
            Integer articleIdInt = Integer.parseInt(articleId);
            if(articleRepository.existsById(articleIdInt)) {
                if(articleRepository.findById(articleIdInt).get().getArticleTopic().getTopicId() == topicIdInt) {
                    articleRepository.deleteById(articleIdInt);
                }
            }
        } catch (NumberFormatException eNF) {
            //
        }
    }

}