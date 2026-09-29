package com.tezyapps.minimalmvvm.counter.data

import com.tezyapps.minimalmvvm.counter.domain.CounterRepository
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

class FakeCounterRepository: CounterRepository {

    override suspend fun getCount(): Int {
        delay(1000.milliseconds)
        return 10
    }

}