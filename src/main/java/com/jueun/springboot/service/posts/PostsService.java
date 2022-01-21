package com.jueun.springboot.service.posts;

import com.jueun.springboot.domain.posts.Posts;
import com.jueun.springboot.domain.posts.PostsRepository;
import com.jueun.springboot.web.dto.PostsListResponseDto;
import com.jueun.springboot.web.dto.PostsResponseDto;
import com.jueun.springboot.web.dto.PostsSaveRequestDto;
import com.jueun.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor //final이 선언된 모든 필드를 인자값으로 하는 생성자를 대신 생성
//생성자를 직접 안쓰고 롬복 어노테이션을 쓴 이유: 해당 클래스의 의존성 관계가 변경될때마다 생성자 코드를 계속해서 수정하는 번거로움 해결
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts=postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        posts.update(requestDto.getTitle(),requestDto.getContent());

        return id;
    }

    @Transactional
    public void delete(Long id){
        Posts posts=postsRepository.findById(id)
                .orElseThrow(() ->new IllegalArgumentException("해당 사용자가 없습니다. id+="+id));
        postsRepository.delete(posts);
    }

    @Transactional(readOnly = true)
    public PostsResponseDto findById(Long id){
        Posts entity=postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }


}

//postsRepository.delete(posts)
//1. JpaRepository에서 이미 delete 메소드를 지원하고 있으니 이를 활용
//2. 엔티티를 파라미터로 삭제할 수도 있고, deleteById 메소드를 이용하명 id로 삭제할 수도 있음
//3. 존재하는 Posts인지 확인을 위해 엔티티 조회 후 그대로 삭제