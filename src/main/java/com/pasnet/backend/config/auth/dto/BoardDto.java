package com.pasnet.backend.config.auth.dto;

import com.pasnet.backend.domain.board.entity.Board;
import com.pasnet.backend.service.board.BoardService;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {
    private Long id;
    private String userId;
    private String title;
    private String content;

    public Board toEntity(){
        Board board = Board.builder()
                .id(id)
                .userId(userId)
                .content(content)
                .title(title)
                .build();
        return board;
    }

    @Builder
    public BoardDto(Long id, String title, String content, String userId) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.content = content;
    }
}
