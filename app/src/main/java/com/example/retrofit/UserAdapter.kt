package com.example.retrofit
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val userList:List<GitHubRepo>):RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.listview,
            parent,false)

        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.textView1.text = currentItem.getRepoName()
        holder.textView2.text = currentItem.getDescription()

    }

    override fun getItemCount() = userList.size

    class UserViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val textView1: TextView = itemView.findViewById(R.id.list_item_pagination_text)
        val textView2: TextView = itemView.findViewById(R.id.view2)
    }
}