package com.codepresso.blog.controller;

import com.codepresso.blog.service.PostService;
import com.codepresso.blog.vo.Post;
import com.codepresso.blog.vo.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    private PostService postService;
    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping(value = "/posts")
    public List<Post> getPostList() {
        List<Post> list = postService.getPostList();
        return list;
    }

    @GetMapping(value = "/post")
    public List<Post> getDetail(@RequestParam(name = "id") Integer id){
        List<Post> list = postService.getPostDetail(id);
        return list;
    }

    @PostMapping(value = "/post")
    public Result addPost(@RequestBody Post post) {
        postService.addPost(post);
        return new Result(200, "Success");
    }

    @PutMapping(value="/post")
    public Result modifyPost(@RequestBody Post post){
        postService.modifyPost(post);
        return new Result(200, "Success");
    }
    @DeleteMapping(value = "/post")
    public Result deletePost(@RequestParam(name = "id") Integer id){
        postService.deletePost(id);
        return new Result(200, "Success");
    }
}
