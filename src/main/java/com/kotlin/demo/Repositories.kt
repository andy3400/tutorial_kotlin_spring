package com.kotlin.demo

import org.springframework.data.repository.CrudRepository

interface ArticleRepository : CrudRepository<Article, Long> {
    fun findBySlug(slug: String): Article?
    fun findAllByOrderByAddressAtDesc():Iterable<Article>
}

interface UserRepository : CrudRepository<User, Long> {
    fun findByLogin(login:String): User?
}