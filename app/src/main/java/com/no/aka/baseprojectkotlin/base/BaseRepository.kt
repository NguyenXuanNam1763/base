/*
 * Copyright (c) 2021/5/11 - 8:35
 * File created by NamNx
 */

package com.no.aka.baseprojectkotlin.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseRepository {
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()


    fun addDisposable(disposable: Disposable) {
        this.compositeDisposable.add(disposable)
    }

    fun disposableAll() {
        this.compositeDisposable.dispose()
    }
}