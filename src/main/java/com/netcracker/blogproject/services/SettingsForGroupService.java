package com.netcracker.blogproject.services;

import com.netcracker.blogproject.entities.Article;
import com.netcracker.blogproject.entities.SettingsForGroup;
import com.netcracker.blogproject.entities.User;
import com.netcracker.blogproject.repositories.ArticleRepository;
import com.netcracker.blogproject.repositories.SettingsForGroupRepository;
import com.netcracker.blogproject.repositories.TopicRepository;
import com.netcracker.blogproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingsForGroupService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SettingsForGroupRepository settingsForGroupRepository;

    public boolean addSettingsForOnePersonInGroup(int topicId, int articleId, String[] nicknameAndRights) {
        if(!topicRepository.existsById(topicId) || !articleRepository.existsById(articleId)) {
            return false;
        } else if (articleRepository.findById(articleId).get().getArticleTopic().getTopicId() != topicId) {
            return false;
        }
        String login = nicknameAndRights[0];
        String rights = nicknameAndRights[1];
        User userFromGroup = null;
        Iterable<User> allUsers = userRepository.findAll();
        for(User user: allUsers) {
            if(user.getUserNickName().equals(login)) {
                userFromGroup = user;
                break;
            }
        }
        Article article = articleRepository.findById(articleId).get();
        if(article == null || userFromGroup == null) return false;
        settingsForGroupRepository.save(new SettingsForGroup(article, userFromGroup, rights));
        return true;
    }

    public boolean deleteSettingsForOnePersonInGroup(int topicId, int articleId) {
        if(!topicRepository.existsById(topicId) || !articleRepository.existsById(articleId)) {
            return false;
        } else if (articleRepository.findById(articleId).get().getArticleTopic().getTopicId() != topicId) {
            return false;
        }
        Iterable<SettingsForGroup> allSettingsForGroup = settingsForGroupRepository.findAll();
        for(SettingsForGroup settingsForGroup: allSettingsForGroup) {
            if(settingsForGroup.getSettingsForGroupArticle().getArticleId() == articleId) {
                settingsForGroupRepository.delete(settingsForGroup);
            }
        }
        return true;
    }

}
