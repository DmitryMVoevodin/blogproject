package com.netcracker.blogproject.services;

import com.netcracker.blogproject.entities.Topic;
import com.netcracker.blogproject.entities.TopicAdmin;
import com.netcracker.blogproject.repositories.ArticleRepository;
import com.netcracker.blogproject.repositories.TopicAdminRepository;
import com.netcracker.blogproject.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private TopicAdminRepository topicAdminRepository;

    @Autowired
    private TopicRepository userRepository;

    public List<Topic> getAllTopics() {
        Iterable<Topic> allTopics = null;
        allTopics = topicRepository.findAll();
        return (List<Topic>) allTopics;
    }


    public boolean addTopicToQueue(TopicAdmin topic) {
        if (!topicAdminRepository.existsById(topic.getTopicId())) {
            topicAdminRepository.save(topic);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteTopicById(int topicId, int userId) {
        if(topicRepository.existsById(topicId)) {
            if(topicRepository.findById(topicId).get().getTopicCreator().getUserId() == userId) {
                topicRepository.deleteById(topicId);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
