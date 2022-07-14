package com.example.week4springhwk.model;

import com.example.week4springhwk.dto.CommentRequestDto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Comment extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private long postid;


    public Comment(CommentRequestDto requestDto){
        this.nickname = requestDto.getNickname();
        this.comment = requestDto.getComment();
        this.postid = requestDto.getPostid();
    }

    public void update(CommentRequestDto requestDto){
        this.nickname = requestDto.getNickname();
        this.comment = requestDto.getComment();
        this.postid = requestDto.getPostid();
    }

}
