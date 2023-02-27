package com.devbugman.kotlinquerydsl.repository

import com.devbugman.kotlinquerydsl.entity.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Member, Long>, MemberCustomRepository {
}