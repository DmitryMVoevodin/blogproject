package com.netcracker.blogproject.controllers;

import com.netcracker.blogproject.conversion.ArticleMapper;
import com.netcracker.blogproject.dto.ArticleDTO;
import com.netcracker.blogproject.entities.Article;
import com.netcracker.blogproject.services.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(value = "Article Controller", description = "Getting, adding, editing and deleting articles by users")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/topic/{topicId}")
public class ArticleController {

    private ArticleMapper articleMapper = Mappers.getMapper(ArticleMapper.class);

    @Autowired
    private ArticleService articleService;

    @ApiOperation(value = "Getting all the articles (a list) for the specific topic considering the rights of reading to the concrete user")
    @RequestMapping(method = RequestMethod.GET, value = "")
    public List<ArticleDTO> getAllArticles(@PathVariable int topicId, int userId) {
        if(userId == 0 || topicId == 0) return null;
        List<Article> articleList = articleService.getAllArticles(topicId, userId);
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

    @ApiOperation(value = "Getting some article by its Id for the specific topic and the user's rights of reading")
    @RequestMapping(method = RequestMethod.GET, value = "/article/{articleId}")
    public ArticleDTO getArticleById(@PathVariable int topicId, @PathVariable int articleId, int userId) {
        if(userId == 0 || topicId == 0 || articleId == 0) return null;
        return articleMapper.articleToArticleDTO(articleService.getArticleById(topicId, articleId, userId));
    }

    @ApiOperation(value = "Adding an article by some user with the verification that it belongs to tne needed topic")
    @RequestMapping(method = RequestMethod.POST, value = "")
    public int addArticle(@PathVariable int topicId, @RequestBody ArticleDTO articleDTO) {
        Article article = articleMapper.articleDTOtoArticle(articleDTO);
        return articleService.addArticle(topicId, article);
    }

    @ApiOperation(value = "Editing the article with the verification of rights of writing")
    @RequestMapping(method = RequestMethod.PUT, value = "/article/{articleId}")
    public boolean editArticleById(@PathVariable int topicId, @PathVariable int articleId, @RequestBody ArticleDTO articleDTO, int userId) {
        if(topicId == 0 || articleId == 0 || userId == 0) return false;
        Article article = articleMapper.articleDTOtoArticle(articleDTO);
        return articleService.editArticleById(topicId, articleId, article, userId);
    }

    @ApiOperation(value = "Determining whether it's available to edit the article")
    @RequestMapping(method = RequestMethod.POST, value = "/article/{articleId}/availability")
    public boolean isEditingAvailableForArticle(@PathVariable int topicId, @PathVariable int articleId, @RequestBody int userId) {
        if(topicId == 0 || articleId == 0 || userId == 0) return false;
        return articleService.isEditingAvailableForArticle(articleId, userId);
    }

    @ApiOperation(value = "Deleting all the articles")
    @RequestMapping(method = RequestMethod.DELETE, value = "")
    public boolean deleteAllArticles(@PathVariable int topicId) {
        return articleService.deleteAllArticles(topicId);
    }

    @ApiOperation(value = "Deleting some article by its Id and the verification of the user rights (admin/creator)")
    @RequestMapping(method = RequestMethod.DELETE, value = "/article/{articleId}")
    public boolean deleteArticleById(@PathVariable int topicId, @PathVariable int articleId, int userId) {
        if(topicId == 0 || articleId == 0 || userId == 0) return false;
        return articleService.deleteArticleById(topicId, articleId, userId);
    }

}