package com.jueun.springboot.web;


/* 오류나서 잠시 주석처리....
@ExtendWith(SpringExtension.class) // junit5
@WebMvcTest(controllers = HelloController.class,
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)
        }
)

public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @WithMockUser(roles="USER")
    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @WithMockUser(roles="USER")
    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                        get("/hello/dto")
                                .param("name", name)
                                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}*/

//@ExtendWith(SpringExtension.class)
//1. 테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행
//2. 여기서는 SpringExtension라는 실행자 사용
//3. 즉, 스프링 부트 테스트와 JUnit 사이에 연결자 역할

//WebMvcTest
//1. 여러 스프링 테스트 어노테이션 중, Web(Spring MVC)에 집중할 수 있는 어노테이션
//2. 선언할 경우 @Controller, @ControllerAdvice 등을 사용할 수 있음
//3. 단, @Service, @Component, @Repository 등은 사용할 수 없음

//Autowired
//1. 스프링이 관리하는 빈(Bean)을 주입 받음

//private MockMvc mvc
//1. 웹 API를 테스트할 때 사용
//2. 스프링 MVC 테스트의 시작점
//3. 이 클래스를 통해 HTTP GET, POST 등에 대한 API 테스트를 할 수 있음

//mvc.perform(get("/hello"))
//1. MockMvc를 통해 /hello 주소로 HTTP GET 요청을 함
//2. 체이닝이 지원되어 아래와 같이 여러 검증 기능을 이어서 선언할 수 있음

//.andExcept(status().isOk())
//1. mvc.perform의 결과를 검증
//2. HTTP Header의 Status를 검증
//3. 200, 404, 500 등의 상태를 검증
//4. 여기선 Ok, 즉 200인지 아닌지 검증

//.andExpect(content().string(hello))
//1. mvc.perform의 결과를 검증
//2. 응답 본문의 내용을 검증
//3. Controller에서 "hello"를 리턴하기 때문에 이 값이 맞는지 검증

//param
//1. API를 테스트할 때 사용될 요청 파라미터를 설정
//2. 단, 값은 String만 허용
//3. 그래서 숫자/날짜 등의 데이터도 등록할 때는 문자열로 변경

//jsonPath
//1. JSON의 응답값을 필드별로 검증할 수 있는 메소드
//2. $를 기준으로 필드명을 명시