package com.example.springbasic.member

interface MemberService {
    fun join(member: Member)
    fun findMember(memberId: Long): Member
}