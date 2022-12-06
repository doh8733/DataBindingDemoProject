package com.example.databindingdemoproject.observerable.demo2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.databindingdemoproject.User
import com.example.databindingdemoproject.databinding.ItemUserBinding
import java.io.PipedReader

class UserAdapter :RecyclerView.Adapter<UserAdapter.ViewHolder>() {

     var listUser = mutableListOf<User>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    class ViewHolder(private var userItemUserBinding: ItemUserBinding) :RecyclerView.ViewHolder(userItemUserBinding.root){

        fun onBind(user: User){
            userItemUserBinding.user = user
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(ItemUserBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(listUser[position])
    }

    override fun getItemCount(): Int {
        return listUser.size
    }
}