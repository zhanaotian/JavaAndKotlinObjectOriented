package com.jkwar.kotlin

/**
 * 单例
 */
object MusicPlay : Player, OnExternalDriverMountListener {
    override fun onMount(driver: Driver) {
    }

    override fun onUnMount() {
    }

    val state: Int = 0

    fun play(url: String) {
        println("播放 $url")
    }

    fun stop() {
        println("停止播放")
    }
}

interface Player

class Driver

interface OnExternalDriverMountListener {
    fun onMount(driver: Driver)

    fun onUnMount()
}


fun main(args: Array<String>) {
    val play = MusicPlay
    play.play("稻草")
    play.stop()
    println(play.state)
}

