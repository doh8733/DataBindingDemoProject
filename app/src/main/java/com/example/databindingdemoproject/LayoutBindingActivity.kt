package com.example.databindingdemoproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.databindingdemoproject.databinding.ActivityLayoutBindingBinding

class LayoutBindingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bindingData: ActivityLayoutBindingBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_layout_binding)

        //kiểu này để chia layout ra làm 2 phần là hiển thị dữ liệu trong layout containt_main_xml và activity_layout_bìnding.xml sẽ bao trùm containt_main.xml
        var user = User()
        user.email = "quochuy1102@gmail.com"
        user.name = "Do Quoc Huy"
        bindingData.user = user
        //add su kien khi bam nut
         val onClick = MyOnClickHandlers(this)
        bindingData.content.handlerClick = onClick
        bindingData.handlersClick = onClick
    }
}