package com.story.sangboo.repositories;

import com.story.sangboo.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    // 댓글을 게시글 id에 따라 불러오는 메서드
    @Query("SELECT c FROM Comment c WHERE c.story.id= :storyId ORDER BY id DESC")
    public List<Comment> getCommentListByStoreId(@Param("storyId") Long storyId);

}
