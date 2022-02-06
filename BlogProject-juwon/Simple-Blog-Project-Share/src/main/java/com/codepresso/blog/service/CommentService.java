package com.codepresso.blog.service;

import com.codepresso.blog.repository.UserCommentRepository;
import com.codepresso.blog.vo.Post;
import com.codepresso.blog.vo.UserComment;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentService {
    Date now = new Date();
    private UserCommentRepository userCommentRepository;

    public CommentService(UserCommentRepository userCommentRepository) {
        this.userCommentRepository = userCommentRepository;
    }

    public List<UserComment> getUserCommentListAll(){
        return userCommentRepository.findAll();
    }

    public List<UserComment> getUserCommentDetail(int id){
        return userCommentRepository.findIndex(id);
    }

    public void addComment(UserComment userComment){
        userComment.setRegDate(now);
        userCommentRepository.save(userComment);
    }


}
