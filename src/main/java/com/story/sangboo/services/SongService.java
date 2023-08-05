package com.story.sangboo.services;

import com.story.sangboo.dtos.song.SongRequestDto;
import com.story.sangboo.dtos.song.SongResponseDto;
import com.story.sangboo.dtos.song.UserSongResponseDto;
import com.story.sangboo.entities.Song;
import com.story.sangboo.entities.Story;
import com.story.sangboo.repositories.SongRepository;
import com.story.sangboo.repositories.StoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SongService {

    private final SongRepository repository;
    private final StoryRepository storyRepository;


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

    public List<UserSongResponseDto> count(List<Song> songs) {
        List<UserSongResponseDto> dtos = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            UserSongResponseDto dto = new UserSongResponseDto();
            if (i == 0) {
                dto.setEmotion("슬픔");
                dto.setCount(0);
            } else if (i == 1) {
                dto.setEmotion("평온");
                dto.setCount(0);
            } else if (i == 2) {
                dto.setEmotion("신남");
                dto.setCount(0);
            } else {
                dto.setEmotion("화남");
                dto.setCount(0);
            }
            dtos.add(dto);
        }
        for (Song song : songs) {
            System.out.println("'" + song.getEmotion().toLowerCase() + "'");
            if (Objects.equals(song.getEmotion().toLowerCase(), "sadness")) {

                System.out.println("'1" + song.getEmotion().toLowerCase() + "'");
                dtos.get(0).setCount(dtos.get(0).getCount() + 1);

            } else if (song.getEmotion().equalsIgnoreCase("pleasure")) {

                System.out.println("'2" + song.getEmotion().toLowerCase() + "'");
                dtos.get(1).setCount(dtos.get(1).getCount() + 1);

            } else if (Objects.equals(song.getEmotion().toLowerCase(), "joy")) {

                System.out.println("'3" + song.getEmotion().toLowerCase() + "'");
                dtos.get(2).setCount(dtos.get(2).getCount() + 1);

            } else if (Objects.equals(song.getEmotion().toLowerCase(), "anger")) {

                System.out.println("'4" + song.getEmotion().toLowerCase() + "'");
                dtos.get(3).setCount(dtos.get(3).getCount() + 1);

            } else {
                continue;
            }
        }
        return dtos;
    }



    @Transactional
    public List<UserSongResponseDto> findAllEmotionByUser(Long id) {
        // 유저가 플레이한 모든 사연 들고오기
        List<Story> stories = storyRepository.findAllByUserId(id);
//        System.out.println(stories.size());
        // 유저가 플레이한 모든 신청곡 불러오기
        List<Song> songs = stories.stream().map((story)->repository.findBySongName(story.getUri())).toList();
        List<UserSongResponseDto> dtos = count(songs);
//        System.out.println(songs.size());
            return dtos;
        }

        @Transactional
    public List<UserSongResponseDto> findAllEmotionByStore(Long id){
        // 가게에서 플레이한 모든 사연 들고오기
            List<Story> stories = storyRepository.findAllByStoreId(id);
            List<Song> songs = stories.stream().map((story)->repository.findBySongName(story.getUri())).toList();
            List<UserSongResponseDto> dtos = count(songs);
            return dtos;
        }

}
