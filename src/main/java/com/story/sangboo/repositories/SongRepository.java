package com.story.sangboo.repositories;

import com.story.sangboo.entities.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SongRepository extends JpaRepository<Song,Long> {

    @Query("SELECT s FROM Song s WHERE s.artist LIKE %:search% OR s.songName LIKE %:search% ORDER BY (CHAR_LENGTH(s.artist) + CHAR_LENGTH(s.songName)) - (CHAR_LENGTH(REPLACE(s.artist, :search, '')) + CHAR_LENGTH(REPLACE(s.songName, :search, ''))) DESC")
    List<Song> findAllBySearch(@Param("search") String search);

    @Query("SELECT s FROM Song s WHERE emotion=:emotion")
    List<Song> findAllByEmotion(@Param("emotion") String emotion);

    @Query("SELECT s FROM Song s WHERE uri= :uri")
    Song findBySongName(@Param("uri") String uri);
}
