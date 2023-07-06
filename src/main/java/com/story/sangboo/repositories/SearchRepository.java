package com.story.sangboo.repositories;

import com.story.sangboo.entities.Search;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SearchRepository extends JpaRepository<Search,Long> {

    @Query("SELECT s FROM Search s WHERE s.user.id = :userId ORDER BY s.id DESC LIMIT 60")
    List<Search> findTop60ByOrderById(@Param("userId") Long userId);

    @Modifying
    @Query("DELETE FROM Search s WHERE s.search = :search AND s.user.id = :userid")
    void deleteBySearch(@Param("search") String search, @Param("userid") Long userid);
}
