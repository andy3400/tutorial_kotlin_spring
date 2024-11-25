package com.kotlin.demo

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

// @Controller : mvc패턴에 따라 클라이언트의 요청, 응답을 반환을 역활
@Controller
class HtmlController {
    // @GetMapping : HTTP GET요청 처리(client -> server), 데이터 요청, 이를 Mapping
    @GetMapping
    fun blog(model: Model): String{
        model["title"] = "Kotlin Demo"
        return "blog"
    }
}