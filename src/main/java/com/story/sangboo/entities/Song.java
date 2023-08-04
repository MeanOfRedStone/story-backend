package com.story.sangboo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Song {

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
