package com.jueun.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class HelloResponseDto {
    private final String name;
    private final int amount;
}

//@Getter
//1. 선언된 모든 필드의 get 메소드를 생성

//@RequiredArgsConstructor
//1. 선언된 모든 final 필드가 포함된 생성자를 생성
//2. final이 없는 필드는 생성자에 포함X