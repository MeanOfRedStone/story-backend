package com.story.sangboo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    /*
    * 사용자 정보 페이지
    * */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String userid;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    // Search 클래스와 1 대 다 매핑
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Search> searches;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Story> stories;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Store> stores;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Comment> comment;

}
