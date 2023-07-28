package com.story.sangboo.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SongRec {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String songName;

    @Column(nullable = false)
    private String artist;

    @Column(nullable = false)
    private String uri;

    @Column(nullable = false)
    private String emotion;

}
