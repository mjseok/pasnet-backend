package com.pasnet.backend.service.board;


import com.pasnet.backend.config.auth.dto.BoardDto;
import com.pasnet.backend.domain.board.entity.Board;
import com.pasnet.backend.domain.board.repository.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

public class BoardService {
    private BoardRepository boardRepository;

    private static final int BLOCK_PAGE_NUM_COUNT=5;
    private static final int PAGE_POST_COUNT=10;

    @Transactional
    public List<BoardDto> getBoardList(Integer pageNum) {
        Page<Board> page = boardRepository.findAll(PageRequest.of(pageNum - 1, PAGE_POST_COUNT, Sort.by(Sort.Direction.ASC, "createdDate")));

        List<Board> boardEntities = page.getContent();
        List<BoardDto> boardDtoList = new ArrayList<>();

        for (Board boardEntity : boardEntities) {
            boardDtoList.add(this.convertEntityToDto(boardEntity));
        }

        return boardDtoList;
    }

    @Transactional
    public Integer[] getPageList(Integer curPageNum){
        Integer[] pageList = new Integer[BLOCK_PAGE_NUM_COUNT];

    }
    private BoardDto convertEntityToDto(Board boardEntity) {
        return BoardDto.builder()
                .id(boardEntity.getId())
                .title(boardEntity.getTitle())
                .content(boardEntity.getContent())
                .userId(boardEntity.getUserId())
                .build();
    }
}
