package com.story.sangboo.dtos.search;

import com.story.sangboo.entities.Search;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class SearchResponseDto {

    private Long id;

    private String search;

    private LocalDateTime saveAt;

    public SearchResponseDto(Search search){

        this.id = search.getId();
        this.search = search.getSearch();
        this.saveAt = search.getSaveAt();

    }

}
