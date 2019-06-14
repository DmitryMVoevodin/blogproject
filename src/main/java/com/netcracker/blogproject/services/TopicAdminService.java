package com.netcracker.blogproject.services;

import com.netcracker.blogproject.entities.TopicAdmin;
import com.netcracker.blogproject.repositories.TopicAdminRepository;
import com.netcracker.blogproject.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicAdminService {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private TopicAdminRepository topicAdminRepository;

    @Autowired
    private TopicRepository userRepository;

    public List<TopicAdmin> getAllTopics() {
        Iterable<TopicAdmin> allTopics = null;
        allTopics = topicAdminRepository.findAll();
        return (List<TopicAdmin>) allTopics;
    }

}
