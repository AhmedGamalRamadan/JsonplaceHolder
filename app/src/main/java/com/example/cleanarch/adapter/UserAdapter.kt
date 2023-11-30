package com.example.cleanarch.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarch.databinding.UserRowBinding
import com.example.cleanarch.model.User

class UserAdapter(val context: Context, val userList: List<User>) :
    RecyclerView.Adapter<UserAdapter.CityViewHolder>() {


    class CityViewHolder(val binding: UserRowBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        return CityViewHolder(
            UserRowBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {

        return userList.size
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {

        val userPosition = userList[position]

        holder.binding.apply {
            tvId.text=userPosition.id.toString()
            tvTitle.text =userPosition.title
            tvBody.text =userPosition.body
        }
    }
}
