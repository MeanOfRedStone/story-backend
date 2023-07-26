package com.story.sangboo.services;

import com.story.sangboo.dtos.song.SongRequestDto;
import com.story.sangboo.dtos.song.SongResponseDto;
import com.story.sangboo.entities.Song;
import com.story.sangboo.repositories.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SongService {

    private final SongRepository repository;

    @Transactional
    public List<SongResponseDto> findAllBySearch(SongRequestDto dto){
        // 검색어를 입력받아서 리스트를 불러오는 메서드
//        List<Song> songs = repository.findAll();
//        List<SongResponseDto> songList = new ArrayList<SongResponseDto>();
//        System.out.println(songs.get(1));
//        System.out.println(dto.getSearch());
//        String search = dto.getSearch().toLowerCase();
//        for(int i = 0; i <songs.size();i++ ){
//            Song song = songs.get(i);
//            String songName = song.getSongName().toLowerCase();
//            String artist = song.getArtist().toLowerCase();
//            if(songName.contains(search) && artist.contains(search) ){
//                songList.add(new SongResponseDto(song));
//            }
//        }
//        return songList;
        return repository.findAllBySearch(dto.getSearch()).stream().map(SongResponseDto::new).toList();

    }




}
