package com.example.week4springhwk.repository;

import com.example.week4springhwk.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByBoardidOrderByModifiedAtDesc(Long board_id);
}
