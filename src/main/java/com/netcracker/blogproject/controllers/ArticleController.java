package com.netcracker.blogproject.controllers;

import com.netcracker.blogproject.conversion.ArticleMapper;
import com.netcracker.blogproject.dto.ArticleDTO;
import com.netcracker.blogproject.entities.Article;
import com.netcracker.blogproject.services.ArticleService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/topic/{topicId}")
public class ArticleController {

    private ArticleMapper articleMapper = Mappers.getMapper(ArticleMapper.class);

    @Autowired
    private ArticleService articleService;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public List<ArticleDTO> getAllArticles(@PathVariable int topicId) {
        List<Article> articleList = articleService.getAllArticles(topicId);
        if(articleList.isEmpty()) {
            return null;
        } else {
            List<ArticleDTO> articleDTOList = new ArrayList<ArticleDTO>();
            for(Article article : articleList) {
                articleDTOList.add(articleMapper.articleToArticleDTO(article));
            }
            return articleDTOList;
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/article/{articleId}")
    public ArticleDTO getArticleById(@PathVariable int topicId, @PathVariable int articleId) {
        return articleMapper.articleToArticleDTO(articleService.getArticleById(topicId, articleId));
    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    public boolean addArticle(@PathVariable int topicId, @RequestBody ArticleDTO articleDTO) {
        Article article = articleMapper.articleDTOtoArticle(articleDTO);
        return articleService.addArticle(topicId, article);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/article/{articleId}")
    public void editArticleById(@PathVariable int topicId, @PathVariable int articleId, @RequestBody ArticleDTO articleDTO) {
        Article article = articleMapper.articleDTOtoArticle(articleDTO);
        articleService.editArticleById(topicId, articleId, article);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "")
    public void deleteAllArticles(@PathVariable int topicId) {
        articleService.deleteAllArticles(topicId);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/article/{articleId}")
    public void deleteArticleById(@PathVariable int topicId, @PathVariable int articleId) {
        articleService.deleteArticleById(topicId, articleId);
    }

}