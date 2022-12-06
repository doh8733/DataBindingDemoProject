package com.example.databindingdemoproject.observerable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.example.databindingdemoproject.MyOnClickHandlers
import com.example.databindingdemoproject.R
import com.example.databindingdemoproject.User
import com.example.databindingdemoproject.databinding.ActivityLayoutBindingBinding
import com.example.databindingdemoproject.databinding.ActivityUpdateUiobserverableBinding

class UpdateUIObserverableActivity : AppCompatActivity() {
    private val viewModel: ViewModels by lazy {
        ViewModelProvider(this,
            ViewModels.ViewModelsFactory())[ViewModels::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var dataBinding: ActivityUpdateUiobserverableBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_update_uiobserverable)
        dataBinding.lifecycleOwner = this
        val user = User()
        user.name = "Do Quoc Huy"
        user.email = "doh8733@gmail.com"
        dataBinding.user = user
        val myOnClickHandlers = MyOnClickHandlers(this)
        dataBinding.like = viewModel
    }
}