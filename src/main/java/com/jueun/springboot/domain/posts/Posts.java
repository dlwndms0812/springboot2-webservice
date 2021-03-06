package com.jueun.springboot.domain.posts;

import com.jueun.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title=title;
        this.content=content;
        this.author=author;
    }

    public void update(String title, String content){
        this.title=title;
        this.content=content;
    }
}

//Entity 클래스에서는 절대 Setter 메소드를 만들지 않음

//@Entity
//1. 테이블과 링크될 클래스임을 나타냄
//2. 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍으로 테이블 이름을 매칭
//ex) SalesManager.java -> sales_manager table

//@Id
//1. 해당 테이블의 PK 필드를 나타냄

//@GeneratedValue
//1. PK의 생성 규칙을 나타냄
//2. 스프링 부트 2.0에서는 GenerationType.IDENTITY 옵션을 추가해야만 auto_increment가 됨

//@Column
//1. 테이블의 칼럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 됨
//2. 사용하는 이유는, 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용
//3. 문자열의 경우 VARCHAR(255)가 기본값이지만, 사이즈를 500으로 늘리고 싶거나 타입을 TEXT로 변경하고 싶은 등의 경우에 사용됨

//@NoArgConstructor
//1. 기본 생성자 자동 추가
//2. public Posts() {}와 같은 효과

//@Getter
//1. 클래스 내 모든 필드의 Getter 메소드를 자동생성

//@Builder
//1. 해당 클래스의 빌더 패턴 클래스를 생성
//2. 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함