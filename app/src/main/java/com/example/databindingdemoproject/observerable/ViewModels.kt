package com.example.databindingdemoproject.observerable

import android.app.Application
import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.databindingdemoproject.User
import java.lang.IllegalArgumentException

class ViewModels() : ViewModel(), Observable {
    val isStringEmpty = MutableLiveData<Boolean>()
    @Bindable
    val _countLike = MutableLiveData<Int>()
    @Bindable
    val like = MutableLiveData<Int>()
    @Bindable
    val name = MutableLiveData<String>()
    @Bindable
    val email = MutableLiveData<String>()
    @Bindable
    val image = MutableLiveData<String>()

    private val listUser = mutableListOf<User>()
    val list = MutableLiveData<MutableList<User>>()

    init {
        isStringEmpty.value = false
    }

    val countLike: LiveData<Int>
        get() = _countLike

    val userName :LiveData<String>
    get() = name

    val emailUser : LiveData<String>
    get() = email
    val _image:LiveData<String>
    get() = image

    fun onUpdateCount() {
        _countLike.value = (countLike.value ?: 0) + 1
    }

    fun addUser() {
        val name = userName.value?:""
        val email = emailUser.value?:""
        val image = _image.value?:""
        val user = User(name,email, like.value ?: 0,image)
        listUser.add(user)
        list.postValue(listUser)
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    class ViewModelsFactory() : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ViewModels::class.java)) {
                return ViewModels() as T
            }
            throw IllegalArgumentException("Don`t know where is viewmodel")
        }
    }
}