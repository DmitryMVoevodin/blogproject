package com.netcracker.blogproject.repositories;

import com.netcracker.blogproject.entities.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
}
