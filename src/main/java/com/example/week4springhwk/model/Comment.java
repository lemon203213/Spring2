package com.example.week4springhwk.model;

import com.example.week4springhwk.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity

public class Comment extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private long postId;


    public Comment(CommentRequestDto commentrequestDto){
        this.nickname = commentrequestDto.getNickname();
        this.comment = commentrequestDto.getComment();
        this.postId = commentrequestDto.getPostId();
    }

    public void updateComment(CommentRequestDto commentrequestDto){
        this.nickname = commentrequestDto.getNickname();
        this.comment = commentrequestDto.getComment();
        this.postId = commentrequestDto.getPostId();
    }

}
