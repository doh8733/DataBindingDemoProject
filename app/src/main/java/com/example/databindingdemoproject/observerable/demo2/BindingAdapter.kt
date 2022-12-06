package com.example.databindingdemoproject.observerable.demo2

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


class BindingAdapter {
    companion object{
        @JvmStatic
        @BindingAdapter("nospace")
        fun setNospace(editText: EditText, value: Boolean) {
            if (value) {
                editText.addTextChangedListener(object : TextWatcher {
                    override fun beforeTextChanged(
                        s: CharSequence,
                        start: Int,
                        count: Int,
                        after: Int
                    ) {
                    }

                    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                        if (s != null && s.toString().contains(" ")) {
                            editText.setText(s.toString().replace(" ", ""))
                            editText.setSelection(editText.text.length)
                        }
                    }

                    override fun afterTextChanged(s: Editable) {}
                })
            }
        }
        @JvmStatic
        @BindingAdapter("android:loadImage")
        fun loadImage(view :ImageView,url : String){
            Glide.with(view.context).load(url).into(view)
        }
    }

}