package com.codepresso.blog.repository;

import com.codepresso.blog.vo.UserComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface UserCommentRepository {
    List<UserComment> findComment(@Param("post_id") Integer id);
    void saveComment(@Param("comment") UserComment userComment);
}
