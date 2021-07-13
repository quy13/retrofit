package com.example.retrofit

class GitHubRepo(private val description:String, private val name:String)
{

    fun getDescription():String{
        return if (description != null && description.isNotEmpty())
            description
        else "No Description"
    }

    fun getRepoName():String{

        return name
    }
}