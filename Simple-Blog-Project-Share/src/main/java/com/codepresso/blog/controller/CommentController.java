package com.codepresso.blog.controller;

import com.codepresso.blog.service.CommentService;
import com.codepresso.blog.vo.Result;
import com.codepresso.blog.vo.UserComment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @GetMapping(value = "/comments")
    public List<UserComment> getComment(@RequestParam(name = "post_id") Integer id){
        List<UserComment> list = commentService.getCommentList(id);
        return list;
    }

    @PostMapping(value = "/comment")
    public Result addComment(@RequestBody UserComment userComment){
        commentService.addComment(userComment);
        return new Result(200, "Success");
    }
}
