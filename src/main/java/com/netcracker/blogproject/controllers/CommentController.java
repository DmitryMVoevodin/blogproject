package com.netcracker.blogproject.controllers;

import com.netcracker.blogproject.conversion.CommentMapper;
import com.netcracker.blogproject.dto.CommentDTO;
import com.netcracker.blogproject.entities.Comment;
import com.netcracker.blogproject.services.CommentService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/topic/{topicId}/article/{articleId}/comment")
public class CommentController {

    private CommentMapper commentMapper = Mappers.getMapper(CommentMapper.class);

    @Autowired
    private CommentService commentService;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public List<CommentDTO> getAllComments(@PathVariable int topicId, @PathVariable int articleId, int userId) {
        if(userId == 0 || topicId == 0 || articleId == 0) return null;
        List<Comment> commentList = commentService.getAllComments(topicId, articleId, userId);
        if(commentList.isEmpty()) {
            return null;
        } else {
            List<CommentDTO> commentDTOList = new ArrayList<CommentDTO>();
            for(Comment comment : commentList) {
                commentDTOList.add(commentMapper.commentToCommentDTO(comment));
            }
            return commentDTOList;
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/availability")
    public boolean isCommentingAvailableForArticle(@PathVariable int topicId, @PathVariable int articleId, @RequestBody int userId) {
        if(topicId == 0 || articleId == 0 || userId == 0) return false;
        return commentService.isCommentingAvailableForArticle(articleId, userId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    public boolean addComment(@PathVariable int topicId, @PathVariable int articleId, @RequestBody Object[] bodyPostForComment) {
        if(bodyPostForComment.length != 2) return false;
        int userId = (int) bodyPostForComment[0];
        String commentContent = (String) bodyPostForComment[1];
        return commentService.addComment(articleId, userId, commentContent);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{commentId}")
    public boolean deleteCommentById(@PathVariable int topicId, @PathVariable int articleId, @PathVariable int commentId, int userId) {
        if(topicId == 0 || articleId == 0 || userId == 0 || commentId == 0) return false;
        return commentService.deleteCommentById(commentId, userId);
    }

}