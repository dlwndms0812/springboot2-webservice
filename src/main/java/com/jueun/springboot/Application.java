package com.jueun.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing //JPA Auditing 활성화
@SpringBootApplication //이것으로 인해 스프링 부트의 자동 설정, 스프링 Bean 읽기/생성 자동 실행
//@SpringBootApplication이 있는 위치부터 설정을 읽기에 이 클래스는 항상 프로젝트의 최상단에 위치
public class Application { //메인 클래스
    public static void main(String[] args){
        //SpringApplication.run으로 인해 내장 WAS(웹 애플리케이션 서버)를 실행
        //-> 항상 서버에 톰캣을 설치할 필요가 없게 되고, 스프링 부트로 만들어진 Jar 파일(실행 가능한 Java 패키징 파일)로 실행
        //내장 WAS를 권장하는 이유: 언제 어디서나 같은 환경에서 스프링 부트를 배포할 수 있기 때문
        SpringApplication.run(Application.class,args);
    }
}
