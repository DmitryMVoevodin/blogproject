package com.netcracker.blogproject.repositories;

import com.netcracker.blogproject.entities.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, Integer> {
}