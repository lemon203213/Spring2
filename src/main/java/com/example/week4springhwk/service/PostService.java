package com.example.week4springhwk.service;

import com.example.week4springhwk.dto.PostRequestDto;
import com.example.week4springhwk.model.Post;
import com.example.week4springhwk.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long update(Long id, PostRequestDto requestDto){
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다."));

        post.update(requestDto);
        return post.getId();
    }

}
