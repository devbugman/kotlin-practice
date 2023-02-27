package com.devbugman.kotlinquerydsl.service

import com.devbugman.kotlinquerydsl.dto.CreateMemberCommand
import com.devbugman.kotlinquerydsl.entity.Member
import com.devbugman.kotlinquerydsl.repository.MemberRepository
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import java.lang.IllegalArgumentException

@SpringBootTest
@Transactional
internal class MemberServiceTest @Autowired constructor(
    private val memberService: MemberService,
    private val memberRepository: MemberRepository
) {

    @Test
    fun `회원 생성`() {
        val email = "test@test.com"
        val name = "test"
        val command = CreateMemberCommand(email = email, name = name)
        val saveMember = memberService.save(command)

        assertThat(saveMember.name).isEqualTo(name)
        assertThat(saveMember.email).isEqualTo(email)
    }

    @Test
    fun `회원 중복 네임`() {
        val email = "test@test.com"
        val name = "test"
        memberRepository.save(Member(email, name))

        val command = CreateMemberCommand(email = email, name = name)

        assertThatThrownBy {
            memberService.save(command)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("${name}은 존재하는 회원")
    }
}