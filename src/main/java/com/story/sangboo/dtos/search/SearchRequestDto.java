package com.story.sangboo.dtos.search;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SearchRequestDto {

    private Long userId;

    private String search;

}
