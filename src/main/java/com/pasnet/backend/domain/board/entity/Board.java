package com.pasnet.backend.domain.board.entity;

import com.pasnet.backend.domain.user.entity.Role;
import com.pasnet.backend.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String title;

    @Column(name="CONTENT", length=1024)
    private String content;

    @Column
    private boolean isPhoto;



    @Builder
    public Board(Long id, String userId, String title,String content,  Boolean isPhoto) {
        this.id=id;
        this.userId = userId;
        this.title=title;
        this.content = content;
    }

    public Board update(String userId, String content) {
        this.userId = userId;
        this.content = content;

        return this;
    }

}
