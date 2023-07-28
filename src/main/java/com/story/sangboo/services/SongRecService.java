package com.story.sangboo.services;

import com.story.sangboo.dtos.songRec.SongRecRequestDto;
import com.story.sangboo.dtos.songRec.SongRecResponseDto;
import com.story.sangboo.entities.SongRec;
import com.story.sangboo.repositories.SongRecRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class SongRecService {

    private final SongRecRepository repository;

    public SongRecResponseDto randomSongRec(SongRecRequestDto dto){

        List<SongRec> songs = repository.findAllByEmotion(dto.getEmotion());
        if(songs.size() > 0) {
            int randomIndex = new Random().nextInt(songs.size());
            SongRec song = songs.get(randomIndex);
            return new SongRecResponseDto(song);
        }
        else{
            throw new RuntimeException("해당 데이터 없음");
        }

    }


}
