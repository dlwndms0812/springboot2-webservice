package com.jueun.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface PostsRepository extends JpaRepository<Posts,Long> {
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC") //SpringDataJpa에서 제공하지 않는 메소드는 쿼리로 작성 가능
    List<Posts> findAllDesc();
}

//Dao 역할
//Entity 클래스와 기본 Entity Repository는 함께 위치해야 함