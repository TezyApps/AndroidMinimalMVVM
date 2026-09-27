package com.tezyapps.minimalmvvm

import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

class FakeCounterRepository: CounterRepository {

    override suspend fun getCount(): Int {
        delay(1000.milliseconds)
        return 10
    }

}