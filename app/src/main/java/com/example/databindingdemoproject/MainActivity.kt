package com.example.databindingdemoproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.databindingdemoproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataBinding :ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val user = User()
        user.name ="Do Quoc Huy"
        user.email = "doh8733@gmail.com"
        //thanhf  phan dataBinding.user .user la thanh phan trong the variable trong layout
        dataBinding.user = user
    }
}