package com.codepresso.blog.controller;

import com.codepresso.blog.service.CommentService;
import com.codepresso.blog.vo.Result;
import com.codepresso.blog.vo.UserComment;
import org.h2.engine.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    //특정 게시물 전체 댓글 조회
    @GetMapping(value = "/comments")
    public List<UserComment> getUserCommentDetail (@RequestParam (name = "id") Integer id){ //post_id로 변경해야함 연관경로를 다 못찾아서 바꾸면 오류남 ㅠ
        List<UserComment> list = commentService.getUserCommentDetail(id);
        return list;
    }

    //댓글 등록
    @PostMapping(value = "/comment")
    public Result addComment (@RequestBody UserComment userComment){
        commentService.addComment(userComment);
        return new Result(200, "Success");

    }

}
