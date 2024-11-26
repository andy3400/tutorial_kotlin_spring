package com.kotlin.demo

import org.springframework.data.repository.CrudRepository

interface ArticleRepositories : CrudRepository<Article, Long> {
    fun findBySlug(slug: String): Article?
    fun findByOrderByAddressDesc():List<Article>
}

interface UserRepository : CrudRepository<User, Long> {
    fun findbyLogin(login:String): User?
}