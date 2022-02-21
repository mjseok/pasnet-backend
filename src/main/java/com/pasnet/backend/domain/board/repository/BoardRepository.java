package com.pasnet.backend.domain.board.repository;

import com.pasnet.backend.domain.board.entity.Board;
import com.pasnet.backend.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findByIdx(String id);
}
