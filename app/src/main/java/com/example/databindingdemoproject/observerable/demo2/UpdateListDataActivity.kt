package com.example.databindingdemoproject.observerable.demo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.databindingdemoproject.R
import com.example.databindingdemoproject.User
import com.example.databindingdemoproject.databinding.ActivityUpdateListDataBinding
import com.example.databindingdemoproject.observerable.ViewModels

class UpdateListDataActivity : AppCompatActivity() {
    private val viewModel: ViewModels by lazy {
        ViewModelProvider(this,
            ViewModels.ViewModelsFactory())[ViewModels::class.java]
    }
    val list = mutableListOf<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataBinding: ActivityUpdateListDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_update_list_data)
        dataBinding.lifecycleOwner = this
        dataBinding.viewmodel = viewModel
        viewModel.list.observe(this){
            var adapter = UserAdapter()
            adapter.listUser = it
            Log.e("DATA", "onCreate: $it", )
            dataBinding.lifecycleOwner = this
            dataBinding.rcvView.layoutManager = LinearLayoutManager(this)
            dataBinding.rcvView.adapter = adapter
        }
    }
    private fun getListData():MutableList<User>{
        val list = mutableListOf<User>()
        list.add(User("hhaha","hah@gmail.com",1))
        list.add(User("hhaha","hah@gmail.com",1))
        list.add(User("hhaha","hah@gmail.com",1))
        list.add(User("hhaha","hah@gmail.com",1))
        list.add(User("hhaha","hah@gmail.com",1))
        list.add(User("hhaha","hah@gmail.com",1))
        return  list
    }
}