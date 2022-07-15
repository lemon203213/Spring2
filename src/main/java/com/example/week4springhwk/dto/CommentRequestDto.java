package com.example.week4springhwk.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentRequestDto {
    private String nickname;
    private String comment;
    private Long postId;
}