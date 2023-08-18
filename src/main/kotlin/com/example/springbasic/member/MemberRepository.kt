package com.example.springbasic.member

interface MemberRepository {
    fun save(member: Member)
    fun findById(memberId: Long): Member
}