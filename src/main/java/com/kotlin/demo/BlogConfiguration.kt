package com.kotlin.demo

import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

// 스프링 app의 설정 클래스 지정
// 보통 @Bean과 같이 사용, 스프링 컨테이너가 관리하는 방식
// 프록시 기반 처리 : CGLIB 프록시 생성, 내부의 @Bean 매서드를 여러번 호출,
// 동일한 객체 반환, 싱글톤 빈 보장.
@Configuration
class BlogConfiguration {

    @Bean
    fun databaseInitializer(userRepository: UserRepository,
                            articleRepository: ArticleRepository) = ApplicationRunner {

        val johnDoe = userRepository.save(User("johnDoe", "John", "Doe"))
        articleRepository.save(Article(
            title = "Lorem",
            headline = "Lorem",
            content = "dolor sit amet",
            author = johnDoe
        ))
        articleRepository.save(Article(
            title = "Ipsum",
            headline = "Ipsum",
            content = "dolor sit amet",
            author = johnDoe
        ))
    }
}
