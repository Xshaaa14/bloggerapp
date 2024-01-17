package com.blogger12.service.impl;

import com.blogger12.entity.Post;
import com.blogger12.exception.ResourceNotFoundException;
import com.blogger12.payload.PostDto;
import com.blogger12.repository.PostRepository;
import com.blogger12.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepo;

    public PostServiceImpl(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public PostDto createPost(PostDto postDto) {

        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        Post savedPost = postRepo.save(post);

        PostDto dto = new PostDto();
        dto.setTitle(savedPost.getTitle());
        dto.setDescription(savedPost.getDescription());
        dto.setContent(savedPost.getContent());


        return dto;

    }

    @Override
    public void deletePost(long id) {
        Post post = postRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("post not found with id " + id)

        );
        postRepo.deleteById(id);
    }
}
