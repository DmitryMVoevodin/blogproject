package com.netcracker.blogproject.services;

import com.netcracker.blogproject.entities.Article;
import com.netcracker.blogproject.entities.Topic;
import com.netcracker.blogproject.entities.User;
import com.netcracker.blogproject.repositories.ArticleRepository;
import com.netcracker.blogproject.repositories.TopicRepository;
import com.netcracker.blogproject.repositories.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceTest {

    @Autowired
    private ArticleService articleService;

    @MockBean
    private ArticleRepository articleRepository;

    @MockBean
    private TopicRepository topicRepository;

    @MockBean
    private UserRepository userRepository;

   /* @Test
    public void GetAllArticlesTest() {
        when(articleRepository.findAll());
    }*/

    @Test
    public void addArticleTest() {

        User user = new User(
                "Абрамова",
                "Светлана",
                "Александровна",
                "abramram@yandex.ru",
                "+79026852233",
                "abram",
                "hhjf1",
                "GaPa",
                false,
                true);
        user.setUserId(3);
        //userRepository.save(user);

        Topic topic = new Topic(
                user,
                "Tate no Yuusha no Nariagari",
                "Готовый перевод - Становление Героя Щита. Выпуск активен, перевод активен.");
        topic.setTopicId(1);

        Article article = new Article(
                topic,
                user,
                "rwc------",
                "Title1",
                "Comment1",
                "Content1");
        article.setArticleId(100);

        boolean isArticleAdded = articleService.addArticle(1, article);
        Assert.assertTrue(isArticleAdded);
    }

}