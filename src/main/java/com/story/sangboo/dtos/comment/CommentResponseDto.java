package com.story.sangboo.dtos.comment;

import com.story.sangboo.entities.Comment;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class CommentResponseDto {

    private Long id;

    private Long storyId;

    private Long userId;

    private String username;

    private String content;

    private LocalDateTime saveAt;

    public CommentResponseDto(Comment comment){
        this.id = comment.getId();
        this.storyId = comment.getStory().getId();
        this.userId = comment.getUser().getId();
        this.username = comment.getUser().getUsername();
        this.content = comment.getContent();
        this.saveAt = comment.getSaveAt();
    }

}
