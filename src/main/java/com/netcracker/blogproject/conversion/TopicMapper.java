package com.netcracker.blogproject.conversion;

import com.netcracker.blogproject.dto.TopicDTO;
import com.netcracker.blogproject.entities.Topic;
import com.netcracker.blogproject.entities.TopicAdmin;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface TopicMapper extends UserMapper{

    @Mappings({
            @Mapping(target = "topicId", source = "entity.topicId"),
            @Mapping(target = "topicCreator", source = "entity.topicCreator"),
            @Mapping(target = "topicTitle", source = "entity.topicTitle"),
            @Mapping(target = "topicComment", source = "entity.topicComment")
    })
    TopicDTO topicToTopicDTO(Topic entity);

    @Mappings({
            @Mapping(target = "topicId", source = "dto.topicId"),
            @Mapping(target = "topicCreator", source = "dto.topicCreator"),
            @Mapping(target = "topicTitle", source = "dto.topicTitle"),
            @Mapping(target = "topicComment", source = "dto.topicComment")
    })
    Topic topicDTOtoTopic(TopicDTO dto);


    //For TopicAdmin

    @Mappings({
            @Mapping(target = "topicId", source = "entity.topicId"),
            @Mapping(target = "topicCreator", source = "entity.topicCreator"),
            @Mapping(target = "topicTitle", source = "entity.topicTitle"),
            @Mapping(target = "topicComment", source = "entity.topicComment")
    })
    TopicDTO topicAdminToTopicDTO(TopicAdmin entity);

    @Mappings({
            @Mapping(target = "topicId", source = "dto.topicId"),
            @Mapping(target = "topicCreator", source = "dto.topicCreator"),
            @Mapping(target = "topicTitle", source = "dto.topicTitle"),
            @Mapping(target = "topicComment", source = "dto.topicComment")
    })
    TopicAdmin topicDTOtoTopicAdmin(TopicDTO dto);

}
