package com.codepresso.blog.repository;

import com.codepresso.blog.vo.Post;
import com.codepresso.blog.vo.UserComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserCommentRepository {
    List<UserComment> findAll();
    List<UserComment> findIndex(@Param("id") Integer id);
    void save(@Param("userComment") UserComment userComment);

}
