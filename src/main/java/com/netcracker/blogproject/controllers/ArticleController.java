package com.netcracker.blogproject.controllers;

import com.netcracker.blogproject.entities.Article;
import com.netcracker.blogproject.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topic/{topicId}")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public List<Article> getAllArticles(@PathVariable String topicId) {
        List<Article> articleList = articleService.getAllArticles(topicId);
        if(articleList.isEmpty()) {
            return null;
        } else {
            return articleService.getAllArticles(topicId);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/article/{articleId}")
    public Article getArticleById(@PathVariable String topicId, @PathVariable String articleId) {
        return articleService.getArticleById(topicId, articleId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    public void addArticle(@PathVariable String topicId, @RequestBody Article article) {
        articleService.addArticle(topicId, article);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/article/{articleId}")
    public void editArticleById(@PathVariable String topicId, @PathVariable String articleId, @RequestBody Article article) {
        articleService.editArticleById(topicId, articleId, article);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "")
    public void deleteAllArticles(@PathVariable String topicId) {
        articleService.deleteAllArticles(topicId);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/article/{articleId}")
    public void deleteArticleById(@PathVariable String topicId, @PathVariable String articleId) {
        articleService.deleteArticleById(topicId, articleId);
    }

}