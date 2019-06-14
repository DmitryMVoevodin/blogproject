package com.netcracker.blogproject.controllers;

import com.netcracker.blogproject.conversion.TopicMapper;
import com.netcracker.blogproject.dto.TopicDTO;
import com.netcracker.blogproject.entities.TopicAdmin;
import com.netcracker.blogproject.services.TopicAdminService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("admin/topic")
public class TopicAdminController {

    private TopicMapper topicMapper = Mappers.getMapper(TopicMapper.class);

    @Autowired
    private TopicAdminService topicAdminService;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public List<TopicDTO> getAllTopics() {
        List<TopicAdmin> topicList = topicAdminService.getAllTopics();
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

}
