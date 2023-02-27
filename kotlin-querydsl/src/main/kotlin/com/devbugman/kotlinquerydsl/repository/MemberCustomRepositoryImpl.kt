package com.devbugman.kotlinquerydsl.repository

import com.devbugman.kotlinquerydsl.entity.Member
import com.devbugman.kotlinquerydsl.entity.QMember.member
import com.querydsl.jpa.impl.JPAQueryFactory

class MemberCustomRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory
) : MemberCustomRepository {
    override fun findByName(name: String): Member? {
        return jpaQueryFactory.select(member)
            .from(member)
            .where(member.name.eq(name))
            .fetchOne()
    }

}