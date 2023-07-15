package com.story.sangboo.dtos.store;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StoreRequestDto {

    private Long userId;

    private String storeName;

}
