package com.kotlin.demo

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne

import java.time.LocalDateTime

@Entity
class Article (
    val title: String,
    val headline: String,
    val content: String,
    // 다대일 형식으로 한 유저에 다른 아티클 작성 가능.
    @ManyToOne var author: User,
    val slug: String = title.toSlug(),
    var addedAt: LocalDateTime = LocalDateTime.now(),
    // primary key
    @Id @GeneratedValue var id: Long? = null )

@Entity
class User(
    var login: String,
    var firstname: String,
    var lastname: String,
    var description: String? = null,
    @Id @GeneratedValue var id: Long? = null )