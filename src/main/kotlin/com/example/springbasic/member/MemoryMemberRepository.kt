package com.example.springbasic.member

class MemoryMemberRepository : MemberRepository {

    companion object {
        val store = mutableMapOf<Long, Member>()
    }

    override fun save(member: Member) {
        store[member.id] = member
    }

    override fun findById(memberId: Long): Member {
        return store[memberId]!!
    }
}