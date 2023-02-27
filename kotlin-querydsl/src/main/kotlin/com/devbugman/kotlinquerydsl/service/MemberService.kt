package com.devbugman.kotlinquerydsl.service

import com.devbugman.kotlinquerydsl.dto.CreateMemberCommand
import com.devbugman.kotlinquerydsl.entity.Member
import com.devbugman.kotlinquerydsl.repository.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberService(
    private val memberRepository: MemberRepository
) {

    @Transactional
    fun save(command: CreateMemberCommand): Member {
        memberRepository.findByName(command.name)?.let { it ->
            throw IllegalArgumentException("${it.name}은 존재하는 회원")
        }
        return memberRepository.save(Member(command.email, command.name))
    }

    @Transactional(readOnly = true)
    fun findByName(name: String): Member? =
        memberRepository.findByName(name)
}