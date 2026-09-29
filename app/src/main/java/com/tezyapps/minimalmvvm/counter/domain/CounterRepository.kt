package com.tezyapps.minimalmvvm.counter.domain

interface CounterRepository {
    suspend fun getCount(): Int
}