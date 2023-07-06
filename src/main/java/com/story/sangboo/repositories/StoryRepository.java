package com.story.sangboo.repositories;

import com.story.sangboo.entities.Story;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StoryRepository extends JpaRepository<Story,Long> {


    @Query("SELECT s FROM Story s where s.store.id = :storeId ORDER BY s.id DESC")
    Page<Story> findStoryByStoreId(@Param("storeId") Long storeId, Pageable pageable);
}
