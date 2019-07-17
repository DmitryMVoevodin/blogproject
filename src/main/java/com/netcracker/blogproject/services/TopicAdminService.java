package com.netcracker.blogproject.services;

import com.netcracker.blogproject.entities.Topic;
import com.netcracker.blogproject.entities.TopicAdmin;
import com.netcracker.blogproject.repositories.TopicAdminRepository;
import com.netcracker.blogproject.repositories.TopicRepository;
import com.netcracker.blogproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TopicAdminService {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private TopicAdminRepository topicAdminRepository;

    @Autowired
    private UserRepository userRepository;

    public List<TopicAdmin> getAllTopics(int userId) {
        if(userRepository.existsById(userId)) {
            if(!userRepository.findById(userId).get().getUserAdmin()) {
                return null;
            }
        } else {
            return null;
        }
        Iterable<TopicAdmin> allTopics = null;
        allTopics = topicAdminRepository.findAll();
        return (List<TopicAdmin>) allTopics;
    }

    public boolean deleteTopicById(int topicId, int userId) {
        if(userRepository.existsById(userId)) {
            if(!userRepository.findById(userId).get().getUserAdmin()) {
                return false;
            }
        } else {
            return false;
        }
        if(topicAdminRepository.existsById(topicId)) {
            topicAdminRepository.deleteById(topicId);
            return true;
        } else {
            return false;
        }
    }

    public boolean addTopicById(int topicId, int userId) {
        if(userRepository.existsById(userId)) {
            if(!userRepository.findById(userId).get().getUserAdmin()) {
                return false;
            }
        } else {
            return false;
        }
        if(topicAdminRepository.existsById(topicId)) {
            TopicAdmin topicAdmin = topicAdminRepository.findById(topicId).get();
            Topic topic = new Topic(topicAdmin.getTopicCreator(), topicAdmin.getTopicTitle(), topicAdmin.getTopicComment());
            topic.setTopicId(0);
            topicRepository.save(topic);
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public boolean acceptTopicById(int topicId, int userId) {
        if(userRepository.existsById(userId)) {
            if(!userRepository.findById(userId).get().getUserAdmin()) {
                return false;
            }
        } else {
            return false;
        }
        if(addTopicById(topicId, userId)) {
            return deleteTopicById(topicId, userId);
        } else {
            return false;
        }
    }
}
