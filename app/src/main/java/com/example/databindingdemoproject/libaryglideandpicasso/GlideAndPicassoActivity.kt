package com.example.databindingdemoproject.libaryglideandpicasso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.databindingdemoproject.R
import com.squareup.picasso.Picasso

class GlideAndPicassoActivity : AppCompatActivity() {
    private val imageView: ImageView by lazy { findViewById<ImageView>(R.id.imageView) }
    private val btnLoadImageViewWithGlide: Button by lazy { findViewById<Button>(R.id.btnLoadImageViewWithGlide) }
    private val btnLoadImageWithPicasso: Button by lazy { findViewById<Button>(R.id.btnLoadImageWithPicasso) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glide_and_picasso)
        btnLoadImageViewWithGlide.setOnClickListener {
            Glide.with(this).load("https://danviet.mediacdn.vn/2020/10/27/1-16037897686321209920078.jpg").into(imageView)
        }
        btnLoadImageWithPicasso.setOnClickListener {
            Picasso.get().load("https://thuthuatphanmem.vn/uploads/2018/09/11/hinh-anh-dep-1_044126531.jpg").resize(300,300).centerInside().into(imageView)
        }

    }
}