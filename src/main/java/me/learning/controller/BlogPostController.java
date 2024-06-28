package me.learning.controller;

import me.learning.domain.model.BlogPost;
import me.learning.service.BlogPostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/blogpost")
public class BlogPostController {

    private final BlogPostService blogPostService;

    public BlogPostController(BlogPostService blogPostService){
        this.blogPostService = blogPostService;
    }

    @GetMapping
    public ResponseEntity<List<BlogPost>> findAll(){
        return ResponseEntity.ok(blogPostService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogPost> findById(@PathVariable Long id){
        return ResponseEntity.ok(blogPostService.findById(id));
    }

    @PostMapping
    public ResponseEntity<BlogPost> create(@RequestBody BlogPost blogPost){
        var blogPostCreated = blogPostService.create(blogPost);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(blogPostCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(blogPostCreated);
    }
}
