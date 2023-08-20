package com.example.springbasic.singleton

/**
 * 싱글톤 패턴을 적용한 서비스
 */
class SingletonService private constructor() {

    companion object {
        private val instance = SingletonService()

        fun getInstance(): SingletonService {
            return instance
        }
    }
}