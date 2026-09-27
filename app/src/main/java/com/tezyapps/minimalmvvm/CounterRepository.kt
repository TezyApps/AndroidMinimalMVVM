package com.tezyapps.minimalmvvm

interface CounterRepository {
    suspend fun getCount(): Int
}