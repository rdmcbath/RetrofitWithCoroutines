package com.mcbath.retrofitwithcoroutines.data


/*link ApiHelper class by using a Repository class*/

class MainRepository(private val apiHelper: ApiHelper) {

/*  The suspend functions can only be called from Coroutines. Adding the keyword suspend helps
    the coroutine to suspend (pause), perform the required job on a network thread
    (if Dispatchers.IO) is used, wait for the response, and then resumes from where it left off
    once the response is available.*/

    suspend fun getUsers() = apiHelper.getUsers()
}