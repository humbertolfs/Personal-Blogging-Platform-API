package me.learning.service;

import me.learning.domain.model.BlogPost;

public interface BlogPostService {
    BlogPost findById(Long id);

    BlogPost create(BlogPost postToCreate);
}
