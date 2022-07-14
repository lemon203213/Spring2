package com.example.week4springhwk.model;

import com.example.week4springhwk.dto.PostRequestDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter //get 함수를 일괄적으로 만들어준다
@Entity //db테이블역할
public class Post extends Timestamped{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String nickname;//닉네임

    @Column(nullable = false)
    private String title;//게시물 제목
    @Column(nullable = false)
    private String contents;//게시물 내용

    public Post(String nickname,String title, String contents ) {
        this.nickname = nickname;
        this.title=title;
        this.contents = contents;
    }
    public Post(PostRequestDto requestDto) {
        this.nickname = requestDto.getNickname();
        this.title=requestDto.getTitle();
        this.contents = requestDto.getContents();
    }

    public void update(PostRequestDto postRequestDto){
        this.nickname=postRequestDto.getNickname();
        this.title=postRequestDto.getTitle();
        this.contents=postRequestDto.getContents();
    }
}
