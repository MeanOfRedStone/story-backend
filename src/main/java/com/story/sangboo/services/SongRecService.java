package com.story.sangboo.services;

import com.story.sangboo.dtos.songRec.SongRecRequestDto;
import com.story.sangboo.dtos.songRec.SongRecResponseDto;
import com.story.sangboo.entities.Song;

import com.story.sangboo.repositories.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class SongRecService {

    private final SongRepository repository;

    public SongRecResponseDto randomSongRec(SongRecRequestDto dto){

        List<Song> songs = repository.findAllByEmotion(dto.getEmotion());
        if(songs.size() > 0) {
            int randomIndex = new Random().nextInt(songs.size());
            Song song = songs.get(randomIndex);
            return new SongRecResponseDto(song);
        }
        else{
            throw new RuntimeException("해당 데이터 없음");
        }

    }


}
