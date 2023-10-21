package com.example.springbasic.lifecycle

class NetworkClient {

    private var url: String? = null

    init {
        println("생성자 호출 url: $url")
        connect()
        call("초기화 연결 메시지")
    }

    fun setUrl(url: String) {
        this.url = url
    }

    // 서비스 시작 시 호출
    private fun connect() {
        println("connect: $url")
    }

    private fun call(message: String) {
        println("call: $url, message: $message")
    }

    // 서비스 종료 시 호출
    fun disconnect() {
        println("close: $url")
    }
}