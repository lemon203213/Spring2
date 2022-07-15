package com.example.week4springhwk.Controller;

import com.example.week4springhwk.dto.PostRequestDto;
import com.example.week4springhwk.model.Post;
import com.example.week4springhwk.repository.PostRepository;
import com.example.week4springhwk.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostService postService;
    private final PostRepository postRepository;


    @PostMapping("/api/posts")//게시물 작성
    public Post createPost(@RequestBody PostRequestDto RequestDto) {
        Post post = new Post(RequestDto);
        return postRepository.save(post);
    }

    @ResponseBody
    @GetMapping("/api/posts")//전체 게시물 조회
    public List<Post> readPost(){
        return postRepository.findAllByOrderByModifiedAtDesc();
    }

    @GetMapping("/api/posts/{id}")//id 게시물 조회
    public Optional<Post> readPost(@PathVariable Long id){
        return postRepository.findById(id);
    }
    //
    @PutMapping("/api/posts/{id}")
    public Long updateBoard(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto) {
        return postService.update_post(id, postRequestDto);
    }
    //삭제
    @DeleteMapping("/api/Posts/{id}")
    public Long deletePost(@PathVariable Long id) {
        postRepository.deleteById(id);
        return id;
    }


}