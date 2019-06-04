package com.netcracker.blogproject.repositories;

import com.netcracker.blogproject.entities.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Integer> {
}