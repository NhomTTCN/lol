package com.example.testkotlinbasic

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext

var counter = 0

fun increment() = GlobalScope.launch {
    println("checkcheck")
    for (i in 1..1000) {
            counter++
            println("checkcheck $i $counter")
    }
}

val mutex = Mutex()

fun increment1() = GlobalScope.launch {
    mutex.withLock {
        for (i in 1..10000) {
            counter++
            println("checkcheck $i $counter")
        }
    }
}

fun main() {
    repeat(100) { increment() }
    Thread.sleep(50000)
}