package com.example.week4springhwk.service;


import com.example.week4springhwk.dto.CommentRequestDto;
import com.example.week4springhwk.model.Comment;
import com.example.week4springhwk.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;


    @Transactional
    public Long updateComment(Long id, CommentRequestDto commentRequestDto) {
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("comment의 아이디가 존재하지 않습니다.")
        );
        comment.updateComment(commentRequestDto);
        return comment.getId();
    }


}
