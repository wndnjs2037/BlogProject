package com.codepresso.blog.service;

import com.codepresso.blog.repository.PostRepository;
import com.codepresso.blog.vo.Post;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class PostService {
    Date now = new Date();
    private PostRepository postRepository;

    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }
    public List<Post> getPostList(){
        return postRepository.findAll();
    }

    public List<Post> getPostDetail(int id){
        return postRepository.findIndex(id);
    }

    public void addPost(Post post){
        post.setRegDate(now);
        post.setUpdtDate(now);
        postRepository.save(post);
    }

    public boolean modifyPost(Post post){
        post.setUpdtDate(now);
        postRepository.modify(post);
        return true;
    }

}
