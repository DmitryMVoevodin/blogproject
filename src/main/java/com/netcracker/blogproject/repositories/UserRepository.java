package com.netcracker.blogproject.repositories;

import com.netcracker.blogproject.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}