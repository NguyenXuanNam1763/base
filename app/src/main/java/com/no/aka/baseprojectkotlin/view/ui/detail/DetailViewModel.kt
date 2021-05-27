package com.no.aka.baseprojectkotlin.view.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.no.aka.baseprojectkotlin.base.BaseViewModel
import com.no.aka.baseprojectkotlin.repository.DetailRepository

class DetailViewModel(private val detailRepository: DetailRepository) : BaseViewModel() {

    private val timeObservable: MutableLiveData<Long> = MutableLiveData()
    val timeLiveData: LiveData<Long>
        get() = timeObservable


    fun countDownTimer() {
        detailRepository.countDownTimer(onNextTime = {
            timeObservable.value = it
        })
    }

    override fun onCleared() {
        detailRepository.destroy()
        super.onCleared()
    }


}