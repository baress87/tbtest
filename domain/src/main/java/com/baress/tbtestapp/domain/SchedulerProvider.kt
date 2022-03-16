package com.baress.tbtestapp.domain

import io.reactivex.Scheduler

interface SchedulerProvider {
    val mainThread: Scheduler

    val io: Scheduler

    val computation: Scheduler

    val newThread: Scheduler
}
