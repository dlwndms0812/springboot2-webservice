package com.jueun.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {
    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modeifiedDate;
}

//@MappedSuperclass
//1. JPA Entity 클래스들이 BaseTimeEntity을 상속할 경우 필드들(createdDate, modifiedDate)도 칼럼으로 인식하도록 함

//@EntityListeners(AuditingEntityListener.class)
//1. BaseTimeEntity 클래스에 Auditing 기능을 포함시킴

//@CreatedDate
//1. Entity가 생성되어 저장될 때 시간이 자동 저장

//@LastModifiedDate
//1. 조회한 Entity의 값을 변경할 때 시간이 자동 저장