package com.devbugman.kotlinquerydsl.entity

import javax.persistence.*

@Entity
class Member(
    var email: String,
    var name: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}