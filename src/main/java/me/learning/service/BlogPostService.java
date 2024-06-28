package me.learning.service;

import me.learning.domain.model.BlogPost;

import java.util.List;

public interface BlogPostService {

    List<BlogPost> findAll();

    BlogPost findById(Long id);

    BlogPost create(BlogPost postToCreate);

    BlogPost modify(BlogPost postToCreate);

    void deleteById(Long id);
}
