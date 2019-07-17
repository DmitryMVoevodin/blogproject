package com.netcracker.blogproject.controllers;

import com.netcracker.blogproject.conversion.TopicMapper;
import com.netcracker.blogproject.dto.TopicDTO;
import com.netcracker.blogproject.entities.TopicAdmin;
import com.netcracker.blogproject.services.TopicAdminService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("admin/topic")
public class TopicAdminController {

    private TopicMapper topicMapper = Mappers.getMapper(TopicMapper.class);

    @Autowired
    private TopicAdminService topicAdminService;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public List<TopicDTO> getAllTopics(int userId) {
        if(userId == 0) return null;
        List<TopicAdmin> topicList = topicAdminService.getAllTopics(userId);
        if(topicList == null) return null;
        if(topicList.isEmpty()) {
            return null;
        } else {
            List<TopicDTO> topicDTOList = new ArrayList<TopicDTO>();
            for(TopicAdmin topic : topicList) {
                topicDTOList.add(topicMapper.topicAdminToTopicDTO(topic));
            }
            return topicDTOList;
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{topicId}")
    public boolean deleteTopicById(@PathVariable int topicId, int userId) {
        if(topicId == 0 || userId == 0) return false;
        return topicAdminService.deleteTopicById(topicId, userId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{topicId}")
    public boolean acceptTopicById(@PathVariable int topicId, @RequestBody int userId) {
        if(topicId == 0 || userId == 0) return false;
        return topicAdminService.acceptTopicById(topicId, userId);
    }

}
