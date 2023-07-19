package com.story.sangboo.repositories;

import com.story.sangboo.entities.Search;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SearchRepository extends JpaRepository<Search,Long> {

    // 유저 id 에 따라 댓글 60 개를 불러오는 메서드
    @Query("SELECT s FROM Search s WHERE s.user.id = :userId ORDER BY s.id DESC LIMIT 60")
    List<Search> findTop60ByOrderById(@Param("userId") Long userId);

    // 해당 유저의 해당 내용에 해당하는 게시글을 전부 삭제하는 메서드
    @Modifying
    @Query("DELETE FROM Search s WHERE s.search = :search AND s.user.id = :userid")
    void deleteBySearch(@Param("search") String search, @Param("userid") Long userid);

    @Modifying
    @Query("DELETE FROM Search s WHERE s.user.id = :userId")
    void deleteByUserId(@Param("userId")Long userId);
}
