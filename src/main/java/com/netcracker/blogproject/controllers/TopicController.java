package com.netcracker.blogproject.controllers;

import com.netcracker.blogproject.conversion.TopicMapper;
import com.netcracker.blogproject.dto.TopicDTO;
import com.netcracker.blogproject.entities.Topic;
import com.netcracker.blogproject.entities.TopicAdmin;
import com.netcracker.blogproject.services.TopicService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/topic")
public class TopicController {

    private TopicMapper topicMapper = Mappers.getMapper(TopicMapper.class);

    @Autowired
    private TopicService topicService;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public List<TopicDTO> getAllTopics() {
        List<Topic> topicList = topicService.getAllTopics();
        if(topicList.isEmpty()) {
            return null;
        } else {
            List<TopicDTO> topicDTOList = new ArrayList<TopicDTO>();
            for(Topic topic : topicList) {
                topicDTOList.add(topicMapper.topicToTopicDTO(topic));
            }
            return topicDTOList;
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/adding")
    public boolean addTopicToQueue(@RequestBody TopicDTO topicDTO) {
        TopicAdmin topic = topicMapper.topicDTOtoTopicAdmin(topicDTO);
        return topicService.addTopicToQueue(topic);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{topicId}/delete")
    public boolean deleteTopicById(@PathVariable int topicId, int userId) {
        if(topicId == 0 || userId == 0) return false;
        return topicService.deleteTopicById(topicId, userId);
    }

}