package com.baress.tbtestapp.data

import com.baress.tbtestapp.domain.SchedulerProvider
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object DefaultSchedulerProvider : SchedulerProvider {

    override val mainThread: Scheduler
        get() = AndroidSchedulers.mainThread()

    override val io: Scheduler
        get() = Schedulers.io()

    override val computation: Scheduler
        get() = Schedulers.computation()

    override val newThread: Scheduler
        get() = Schedulers.newThread()
}
