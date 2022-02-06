package com.codepresso.blog.service;

import com.codepresso.blog.repository.PostRepository;
import com.codepresso.blog.repository.UserCommentRepository;
import com.codepresso.blog.vo.UserComment;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.Comment;
import java.util.Date;
import java.util.List;

@Service
public class CommentService {
    private UserCommentRepository userCommentRepository;

    public CommentService(UserCommentRepository userCommentRepository){
        this.userCommentRepository = userCommentRepository;
    }

    public List<UserComment> getCommentList(int id) {
        return userCommentRepository.findComment(id);
    }

    public void addComment(UserComment userComment){
        userCommentRepository.saveComment(userComment);
    }
}
