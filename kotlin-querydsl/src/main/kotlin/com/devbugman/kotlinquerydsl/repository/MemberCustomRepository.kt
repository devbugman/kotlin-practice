package com.devbugman.kotlinquerydsl.repository

import com.devbugman.kotlinquerydsl.entity.Member

interface MemberCustomRepository {
    fun findByName(name: String): Member?
}