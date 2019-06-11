package com.netcracker.blogproject.conversion;

import com.netcracker.blogproject.dto.ArticleDTO;
import com.netcracker.blogproject.entities.Article;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface ArticleMapper extends TopicMapper {

    @Mappings({
            @Mapping(target = "articleId", source = "entity.articleId"),
            @Mapping(target = "articleTopic", source = "entity.articleTopic"),
            @Mapping(target = "articleCreator", source = "entity.articleCreator"),
            @Mapping(target = "articleRights", source = "entity.articleRights"),
            @Mapping(target = "articleTitle", source = "entity.articleTitle"),
            @Mapping(target = "articleComment", source = "entity.articleComment"),
            @Mapping(target = "articleContent", source = "entity.articleContent")
    })
    ArticleDTO articleToArticleDTO(Article entity);

    @Mappings({
            @Mapping(target = "articleId", source = "dto.articleId"),
            @Mapping(target = "articleTopic", source = "dto.articleTopic"),
            @Mapping(target = "articleCreator", source = "dto.articleCreator"),
            @Mapping(target = "articleRights", source = "dto.articleRights"),
            @Mapping(target = "articleTitle", source = "dto.articleTitle"),
            @Mapping(target = "articleComment", source = "dto.articleComment"),
            @Mapping(target = "articleContent", source = "dto.articleContent")
    })
    Article articleDTOtoArticle(ArticleDTO dto);

}
