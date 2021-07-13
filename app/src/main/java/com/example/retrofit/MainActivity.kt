package com.example.retrofit

import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView:RecyclerView = findViewById(R.id.recycler_view)
        val builder:Retrofit.Builder = Retrofit.Builder()
                                               .baseUrl("https://api.github.com/")
                                               .addConverterFactory(GsonConverterFactory.create())

        val retrofit:Retrofit = builder.build()
        val client : GitHubClient =retrofit.create(GitHubClient::class.java)


        val call : Call<List<GitHubRepo>> = client.reposForUser("markerikson")
        call.enqueue(object : Callback<List<GitHubRepo>> {
            override fun onResponse(
                call: Call<List<GitHubRepo>>,
                response: Response<List<GitHubRepo>>
            ) {
                val repos = response.body()
                recyclerView.apply {
                    recyclerView.adapter = UserAdapter(userList = repos!!)
                    recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                    recyclerView.setHasFixedSize(true)

                }
            }

            override fun onFailure(call: Call<List<GitHubRepo>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "error :(", Toast.LENGTH_SHORT).show()
            }

        })
    }
}