package com.kotlin.demo

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.server.ResponseStatusException

// @Controller : mvc패턴에 따라 클라이언트의 요청, 응답을 반환을 역활
@Controller
class HtmlController(private val repository: ArticleRepository) {
    // @GetMapping : HTTP GET요청 처리(client -> server), 데이터 요청, 이를 Mapping
    @GetMapping("/")
    fun blog(model: Model): String{
        model["title"] = "blog"
        model["article"] = repository.findAllByOrderByAddressAtDesc().map {
            it.render()
        }
        return "blog"
    }

    @GetMapping("/article/{slug}")
    fun article(@PathVariable slug:String, model: Model): String {
        val article = repository
            .findBySlug(slug)
            ?.render()
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "This article does not exist")
            model["title"] = article.title
            model["article"] = article

            return "article"
    }

    // Ktor에서 HTML 템플릿을 렌디링 할 때 render() 메소드 사용
    fun Article.render() = RenderedArticle(
        slug,
        title,
        headline,
        content,
        author,
        addedAt.format()
    )

    // data 클래스 정의, data 저장, 관리 위한 클래스
    data class RenderedArticle(
        val slug: String,
        val title: String,
        val headline: String,
        val content: String,
        val author: User,
        val addedAt: String
    )
}