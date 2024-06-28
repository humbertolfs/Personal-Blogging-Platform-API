package me.learning.service.impl;

import me.learning.domain.model.BlogPost;
import me.learning.domain.repository.BlogPostRepository;
import me.learning.service.BlogPostService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class BlogPostServiceImpl implements BlogPostService {

    private final BlogPostRepository blogPostRepository;

    public BlogPostServiceImpl(BlogPostRepository blogPostRepository){
        this.blogPostRepository = blogPostRepository;
    }

    @Override
    public BlogPost findById(Long id) {
        return blogPostRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public BlogPost create(BlogPost blogPostToCreate) {
        if (blogPostToCreate.getId() != null && blogPostRepository.existsById(blogPostToCreate.getId())){
            throw new IllegalArgumentException("This ID already exists.");
        }
        return blogPostRepository.save(blogPostToCreate);
    }
}
