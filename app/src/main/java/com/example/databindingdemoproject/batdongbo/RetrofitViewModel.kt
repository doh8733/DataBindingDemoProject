package com.example.databindingdemoproject.batdongbo

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import java.lang.IllegalArgumentException

class RetrofitViewModel(val app :Application):ViewModel() {

    fun getAllData() = liveData(Dispatchers.IO){
        emit(DataResponse.loading(data = null))
        try {
            emit(DataResponse.success(data = RetrofitClient.api.getAllData()))
        }catch (e : Exception){
            emit(DataResponse.error(data = null, e.message?:"ERROR"))
        }
    }
    class RetrofitViewModelFactory(private val app : Application):ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(RetrofitViewModel::class.java)){
                return RetrofitViewModel(app) as T
            }
            throw  IllegalArgumentException("Unable construct viewModel")
        }
    }
}