package com.example.databindingdemoproject

import android.content.Context
import android.view.View
import android.widget.Toast

class MyOnClickHandlers(private val context: Context) {
    fun onFabClicked(view : View){
        Toast.makeText(context, "Hi this is onclick event when i using dataBinding", Toast.LENGTH_SHORT).show()
    }
    fun onClickWithParams(view: View,user: User){
        Toast.makeText(context, "Hi im ${user.name}", Toast.LENGTH_SHORT).show()
    }
    fun onLongClickButton(view: View): Boolean{
        Toast.makeText(context, "Hi this is long click with dataBinding", Toast.LENGTH_SHORT).show()
        return false
    }
    
}