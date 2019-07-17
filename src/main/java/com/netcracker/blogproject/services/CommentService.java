package com.netcracker.blogproject.services;

import com.netcracker.blogproject.entities.Article;
import com.netcracker.blogproject.entities.Comment;
import com.netcracker.blogproject.entities.SettingsForGroup;
import com.netcracker.blogproject.entities.User;
import com.netcracker.blogproject.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SettingsForGroupRepository settingsForGroupRepository;

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getAllComments(int topicId, int articleId, int userId) {
        Iterable<Comment> allComments = null;
        allComments = commentRepository.findAll();
        List<Comment> comments = new ArrayList<Comment>();
        for (Comment comment : allComments) {
            if(comment.getCommentArticle().getArticleId() == articleId) {
                comments.add(comment);
            }
        }
        return comments;
    }


    public boolean isCommentingAvailableForArticle(int articleId, int userId) {
        boolean accessFlag = false;
        Article article = null;
        if(articleRepository.existsById(articleId)) {
            Iterable<SettingsForGroup> allSettingsForGroup = null;
            article = articleRepository.findById(articleId).get();
            byte[] rightsOfAccess = article.getArticleRights().getBytes();
            if((rightsOfAccess[2] == (int)'c') && (article.getArticleCreator().getUserId() == userId)) {
                accessFlag = true;
            } else if(rightsOfAccess[8] == (int)'c') {
                accessFlag = true;
            } else if(rightsOfAccess[5] == (int)'c') {
                allSettingsForGroup = settingsForGroupRepository.findAll();
                for(SettingsForGroup right: allSettingsForGroup) {
                    if((right.getSettingsForGroupArticle().getArticleId() == article.getArticleId()) &&
                            (right.getSettingsForGroupUser().getUserId() == userId)) {
                        if(right.getSettingsForGroupRights().getBytes()[2] == (int)'c') {
                            accessFlag = true;
                        }
                        break;
                    }
                }
            }
        }
        return accessFlag;
    }

    public boolean addComment(int articleId, int userId, String commentContent) {
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
        if (isCommentingAvailableForArticle(articleId, userId) || isAdmin) {
            Article article = articleRepository.findById(articleId).get();
            User user = userRepository.findById(userId).get();
            Comment comment = new Comment(article, user, commentContent);
            comment.setCommentId(0);
            commentRepository.save(comment);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteCommentById(int commentId, int userId) {
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
        if(commentRepository.existsById(commentId)) {
            if(commentRepository.findById(commentId).get().getCommentUser().getUserId() == userId || isAdmin) {
                commentRepository.deleteById(commentId);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
