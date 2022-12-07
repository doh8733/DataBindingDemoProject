package com.example.databindingdemoproject.batdongbo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.databindingdemoproject.R
import com.example.databindingdemoproject.batdongbo.Status.*

class RetrofitCallActivity : AppCompatActivity() {
    private val tvText: TextView by lazy { findViewById<TextView>(R.id.tvText) }
    private val btnCall: Button by lazy { findViewById<Button>(R.id.btnCall) }

    private val retofitViewmodel :RetrofitViewModel by lazy {
        ViewModelProvider(
            this,RetrofitViewModel.RetrofitViewModelFactory(this.application)
        )[RetrofitViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit_call)


    }
    private fun getAllData(){
        retofitViewmodel.getAllData().observe(this){
            it.let {
                when(it.status){
                    SUCCESS -> {
                        if (it.data?.code() == 200){
                         tvText.text = it.data.body().toString()
                        }
                        else{
                            Toast.makeText(this, "That Bai", Toast.LENGTH_SHORT).show()
                        }
                    }
                    LOAD -> {
                    }
                    ERROR -> {
                    }
                }
            }
        }
    }
}