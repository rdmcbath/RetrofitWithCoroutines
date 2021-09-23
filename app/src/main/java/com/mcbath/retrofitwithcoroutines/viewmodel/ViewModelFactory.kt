package com.mcbath.retrofitwithcoroutines.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mcbath.retrofitwithcoroutines.data.ApiHelper
import com.mcbath.retrofitwithcoroutines.data.MainRepository

/*We need to pass parameters/arguments to our ViewModel; therefore, we need to use a Factory that
can be passed to ViewModelProviders to use when an instance of MyViewModel is required. If no
arguments are needed you could use the simple one they provide when instantiating in the UI class.
Here we are passing in our ApiHelper*/

class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(MainRepository(apiHelper)) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}
