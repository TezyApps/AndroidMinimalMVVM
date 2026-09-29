package com.tezyapps.minimalmvvm.counter.data

interface CounterRepository {
    suspend fun getCount(): Int
}