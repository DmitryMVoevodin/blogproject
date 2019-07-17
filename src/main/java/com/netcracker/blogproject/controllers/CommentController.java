package com.netcracker.blogproject.controllers;

import com.netcracker.blogproject.conversion.CommentMapper;
import com.netcracker.blogproject.dto.CommentDTO;
import com.netcracker.blogproject.entities.Comment;
import com.netcracker.blogproject.services.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(value = "Comment Controller", description = "Getting, adding, deleting comments and determining its availability")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/topic/{topicId}/article/{articleId}/comment")
public class CommentController {

    private CommentMapper commentMapper = Mappers.getMapper(CommentMapper.class);

    @Autowired
    private CommentService commentService;

    @ApiOperation(value = "Getting all the comments (a list) of the specific article")
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

    @ApiOperation(value = "Determining whether the article is available for the commenting by some specific user")
    @RequestMapping(method = RequestMethod.POST, value = "/availability")
    public boolean isCommentingAvailableForArticle(@PathVariable int topicId, @PathVariable int articleId, @RequestBody int userId) {
        if(topicId == 0 || articleId == 0 || userId == 0) return false;
        return commentService.isCommentingAvailableForArticle(articleId, userId);
    }

    @ApiOperation(value = "Adding a comment to the article by some specific user")
    @RequestMapping(method = RequestMethod.POST, value = "")
    public boolean addComment(@PathVariable int topicId, @PathVariable int articleId, @RequestBody Object[] bodyPostForComment) {
        if(bodyPostForComment.length != 2) return false;
        int userId = (int) bodyPostForComment[0];
        String commentContent = (String) bodyPostForComment[1];
        return commentService.addComment(articleId, userId, commentContent);
    }

    @ApiOperation(value = "Deleting the comment of some specific article considering the rights of the user")
    @RequestMapping(method = RequestMethod.DELETE, value = "/{commentId}")
    public boolean deleteCommentById(@PathVariable int topicId, @PathVariable int articleId, @PathVariable int commentId, int userId) {
        if(topicId == 0 || articleId == 0 || userId == 0 || commentId == 0) return false;
        return commentService.deleteCommentById(commentId, userId);
    }

}