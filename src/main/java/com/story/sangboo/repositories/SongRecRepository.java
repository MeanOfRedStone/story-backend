package com.story.sangboo.repositories;


import com.story.sangboo.entities.SongRec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SongRecRepository extends JpaRepository<SongRec,Long> {

 @Query("SELECT s FROM SongRec s WHERE emotion=:emotion")
    List<SongRec> findAllByEmotion(@Param("emotion") String emotion);

}
