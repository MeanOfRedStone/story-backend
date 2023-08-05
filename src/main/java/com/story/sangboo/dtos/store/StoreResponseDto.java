package com.story.sangboo.dtos.store;

import com.story.sangboo.entities.Store;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StoreResponseDto {

    private Long id;

    private String storeName;

    private String username;

   



    public StoreResponseDto(Store store){
        this.id = store.getId();
        this.storeName = store.getStoreName();
        this.username = store.getUser().getUsername();
    }


}
