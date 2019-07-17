package com.netcracker.blogproject.services;

import com.netcracker.blogproject.entities.Article;
import com.netcracker.blogproject.entities.SettingsForGroup;
import com.netcracker.blogproject.repositories.ArticleRepository;
import com.netcracker.blogproject.repositories.SettingsForGroupRepository;
import com.netcracker.blogproject.repositories.TopicRepository;
import com.netcracker.blogproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SettingsForGroupRepository settingsForGroupRepository;

    public List<Article> getAllArticles(int topicId, int userId) {

        boolean isAdmin = false;
        if(userRepository.existsById(userId)) {
            if(userRepository.findById(userId).get().getUserAdmin()) {
                isAdmin = true;
            } else {
                isAdmin = false;
            }
        } else {
            return null;
        }

        boolean accessFlag = false;
        byte[] rightsOfAccess = null;
        Iterable<SettingsForGroup> allSettingsForGroup = null;
        List<Article> articles = null;
        articles = new ArrayList<>();
        Iterable<Article> allArticles = articleRepository.findAll();
        for (Article article : allArticles) {
            /******************************* Обработка прав доступа *******************************/
            accessFlag = false;
            rightsOfAccess = article.getArticleRights().getBytes();
            if(isAdmin) {
                accessFlag = true;
            } else if((rightsOfAccess[0] == (int)'r') && (article.getArticleCreator().getUserId() == userId)) {
                accessFlag = true;
            } else if(rightsOfAccess[6] == (int)'r') {
                accessFlag = true;
            } else if(rightsOfAccess[3] == (int)'r') {
                allSettingsForGroup = settingsForGroupRepository.findAll();
                for(SettingsForGroup right: allSettingsForGroup) {
                    if((right.getSettingsForGroupArticle().getArticleId() == article.getArticleId()) &&
                            (right.getSettingsForGroupUser().getUserId() == userId)) {
                        if(right.getSettingsForGroupRights().getBytes()[0] == (int)'r') {
                            accessFlag = true;
                        }
                        break;
                    }
                }
            }
            if(!accessFlag) continue;
            /**************************************************************************************/
            if (article.getArticleTopic().getTopicId() == topicId) {
                articles.add(article);
            }
        }
        return articles;
    }

    public Article getArticleById(int topicId, int articleId, int userId) {
        Article article = articleRepository.findById(articleId).get();
            if (topicId != article.getArticleTopic().getTopicId()) {
                article = null;
            }
        return article;
    }

    public int addArticle(int topicId, Article article) {
        if (topicRepository.existsById(topicId) && !articleRepository.existsById(article.getArticleId())) {
            if (topicRepository.findById(topicId).get().equals(article.getArticleTopic())) {
                Article articleSaved = articleRepository.save(article);
                return articleSaved.getArticleId();
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    @Transactional
    public boolean editArticleById(int topicId, int articleId, Article article, int userId) {
        if(userRepository.existsById(userId)) {
            boolean isAdmin = false;
            if(userRepository.findById(userId).get().getUserAdmin()) {
                isAdmin = true;
            } else {
                isAdmin = false;
            }
            if(isEditingAvailableForArticle(articleId, userId) || isAdmin) {
                if (topicRepository.existsById(topicId) && articleRepository.existsById(article.getArticleId())) {
                    if (topicRepository.findById(topicId).get().equals(article.getArticleTopic()) &&
                            article.getArticleId() == articleId) {
                        articleRepository.save(article);
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean deleteAllArticles(int topicId) {
        Iterable<Article> allArticles = articleRepository.findAll();
        for (Article article : allArticles) {
            if (article.getArticleTopic().getTopicId() == topicId) {
                articleRepository.deleteById(article.getArticleId());
            }
        }
        if (articleRepository.count() > 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean deleteArticleById(int topicId, int articleId, int userId) {

        boolean isAdmin = false;
        if(userRepository.existsById(userId)) {
            if(userRepository.findById(userId).get().getUserAdmin()) {
                isAdmin = true;
            } else {
                isAdmin = false;
            }
        } else {
            return false;
        }

        if (articleRepository.existsById(articleId)) {
            if((articleRepository.findById(articleId).get().getArticleCreator().getUserId() != userId) && (!isAdmin)) return false;
            if ((articleRepository.findById(articleId).get().getArticleTopic().getTopicId() == topicId) || (isAdmin)) {
                articleRepository.deleteById(articleId);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean isEditingAvailableForArticle(int articleId, int userId) {
        boolean accessFlag = false;
        Article article = null;
        if(articleRepository.existsById(articleId)) {
            Iterable<SettingsForGroup> allSettingsForGroup = null;
            article = articleRepository.findById(articleId).get();
            byte[] rightsOfAccess = article.getArticleRights().getBytes();
            if((rightsOfAccess[1] == (int)'w') && (article.getArticleCreator().getUserId() == userId)) {
                accessFlag = true;
            } else if(rightsOfAccess[7] == (int)'w') {
                accessFlag = true;
            } else if(rightsOfAccess[4] == (int)'w') {
                allSettingsForGroup = settingsForGroupRepository.findAll();
                for(SettingsForGroup right: allSettingsForGroup) {
                    if((right.getSettingsForGroupArticle().getArticleId() == article.getArticleId()) &&
                            (right.getSettingsForGroupUser().getUserId() == userId)) {
                        if(right.getSettingsForGroupRights().getBytes()[1] == (int)'w') {
                            accessFlag = true;
                        }
                        break;
                    }
                }
            }
        }
        return accessFlag;
    }

}