package com.mcbath.retrofitwithcoroutines.data

import com.mcbath.retrofitwithcoroutines.model.User
import retrofit2.http.GET

interface ApiService {

    /*  The suspend functions can only be called from Coroutines. Adding the keyword suspend helps
    the coroutine to suspend (pause), perform the required job on a network thread
    (if Dispatchers.IO) is used, wait for the response, and then resumes from where it left off
    once the response is available.*/

    @GET("users")
    suspend fun getUsers(): List<User>
}