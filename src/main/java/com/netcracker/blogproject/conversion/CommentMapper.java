package com.netcracker.blogproject.conversion;

import com.netcracker.blogproject.dto.CommentDTO;
import com.netcracker.blogproject.entities.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface CommentMapper {

    @Mappings({
            @Mapping(target = "commentId", source = "entity.commentId"),
            @Mapping(target = "commentArticleId", source = "entity.commentArticle.articleId"),
            @Mapping(target = "commentUserId", source = "entity.commentUser.userId"),
            @Mapping(target = "commentUserNickName", source = "entity.commentUser.userNickName"),
            @Mapping(target = "commentContent", source = "entity.commentContent")
    })
    CommentDTO commentToCommentDTO(Comment entity);

}