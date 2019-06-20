package com.netcracker.blogproject.services;

import com.netcracker.blogproject.entities.Article;
import com.netcracker.blogproject.entities.Topic;
import com.netcracker.blogproject.entities.User;
import com.netcracker.blogproject.repositories.ArticleRepository;
import com.netcracker.blogproject.repositories.TopicRepository;
import com.netcracker.blogproject.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceTest {

    List<User> users;
    List<Topic> topics;
    List<Article> articles;

    @Autowired
    private ArticleService articleService;

    @MockBean
    private ArticleRepository articleRepository;

    @MockBean
    private TopicRepository topicRepository;

    @MockBean
    private UserRepository userRepository;

    @Before
    public void setUp() {

        users = new ArrayList<>();
        topics = new ArrayList<>();
        articles = new ArrayList<>();

        DataInitUtils.insertIntoList(users, topics, articles);

    }

    @Test
    public void getAllArticlesTest() {

        int topicId = 2;

        when(articleRepository.findAll()).thenReturn(articles);

        List<Article> articlesExpected = new ArrayList<>();
        for(Article article : articles) {
            if(article.getArticleTopic().getTopicId() == topicId) {
                articlesExpected.add(article);
            }
        }
        assertEquals(articlesExpected, articleService.getAllArticles(topicId));

        verify(articleRepository).findAll();

    }

    @Test
    public void getArticleByIdTest() {

        int topicId = 4;
        int articleId = 4;

        when(articleRepository.findById(4)).thenReturn(Optional.ofNullable(articles.get(articleId - 1)));

        assertEquals(articles.get(articleId - 1), articleService.getArticleById(topicId, articleId));

        verify(articleRepository, times(1)).findById(articleId);

    }

    @Test
    public void addArticleTest() {

        int userId = 3;
        int topicId = 1;
        int articleId = 100;

        User user = new User(
                "Абрамова", "Светлана", "Александровна",
                "abramram@yandex.ru", "+79026852233",
                "abram", "hhjf1", "GaPa",
                false, true);
        user.setUserId(userId);

        Topic topic = new Topic(
                user, "Tate no Yuusha no Nariagari",
                "Готовый перевод - Становление Героя Щита. Выпуск активен, перевод активен.");
        topic.setTopicId(topicId);

        Article article = new Article(
                topic, user, "rwc------", "Title1", "Comment1", "Content1");
        article.setArticleId(articleId);

        when(topicRepository.existsById(topicId)).thenReturn(true);
        when(articleRepository.existsById(articleId)).thenReturn(false);
        when(topicRepository.findById(topicId)).thenReturn(Optional.ofNullable(topics.get(topicId - 1)));
        when(articleRepository.save(article)).thenReturn(article);

        assertTrue(articleService.addArticle(topicId, article));

        verify(topicRepository, times(1)).existsById(topicId);
        verify(articleRepository, times(1)).existsById(articleId);
        verify(topicRepository, times(1)).findById(topicId);
        verify(articleRepository, times(1)).save(article);

    }

    @Test
    public void editArticleByIdTest() {

        int userId = 3;
        int topicId = 1;
        int articleId = 1;

        User user = new User(
                "Абрамова", "Светлана", "Александровна",
                "abramram@yandex.ru", "+79026852233",
                "abram", "hhjf1", "GaPa",
                false, true);
        user.setUserId(userId);

        Topic topic = new Topic(
                user, "Tate no Yuusha no Nariagari",
                "Готовый перевод - Становление Героя Щита. Выпуск активен, перевод активен.");
        topic.setTopicId(topicId);

        Article article = new Article(
                topic, user, "rwc------", "Title1", "Comment1", "Content1");
        article.setArticleId(articleId);

        when(topicRepository.existsById(topicId)).thenReturn(true);
        when(articleRepository.existsById(article.getArticleId())).thenReturn(true);
        when(topicRepository.findById(topicId)).thenReturn(Optional.ofNullable(topics.get(topicId - 1)));
        when(articleRepository.save(article)).thenReturn(article);

        assertTrue(articleService.editArticleById(topicId, articleId, article));

        verify(topicRepository, times(1)).existsById(topicId);
        verify(articleRepository, times(1)).existsById(article.getArticleId());
        verify(topicRepository, times(1)).findById(topicId);
        verify(articleRepository).save(article);

    }

    @Test
    public void deleteAllArticlesTest() {

        int topicId = 2;
        int size = 0;

        List<Article> articlesExpected = new ArrayList<>();
        for(Article article : articles) {
            if(article.getArticleTopic().getTopicId() == topicId) {
                size++;
            }
        }

        when(articleRepository.findAll()).thenReturn(articles);
        when(articleRepository.count()).thenReturn(0L);

        assertTrue(articleService.deleteAllArticles(topicId));

        verify(articleRepository, times(1)).findAll();
        verify(articleRepository,times(size)).deleteById(anyInt());
    }

    @Test
    public void deleteArticleByIdTest() {

        int topicId = 2;
        int articleId = 2;

        when(articleRepository.existsById(articleId)).thenReturn(true);
        when(articleRepository.findById(articleId)).thenReturn(Optional.ofNullable(articles.get(articleId - 1)));

        assertTrue(articleService.deleteArticleById(topicId, articleId));

        verify(articleRepository, times(1)).existsById(articleId);
        verify(articleRepository, times(1)).findById(articleId);

    }

}