package com.mcbath.retrofitwithcoroutines.data

/*API Helper class is passed as a param to MainRepository*/

/*  The suspend functions can only be called from Coroutines. Adding the keyword suspend helps
    the coroutine to suspend (pause), perform the required job on a network thread
    (if Dispatchers.IO) is used, wait for the response, and then resumes from where it left off
    once the response is available. */

class ApiHelper(private val apiService: ApiService) {
    suspend fun getUsers() = apiService.getUsers()
}