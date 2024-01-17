package com.blogger12.service;

import com.blogger12.payload.PostDto;

public interface PostService {

    public PostDto createPost(PostDto postDto);

    void deletePost(long id);
}
