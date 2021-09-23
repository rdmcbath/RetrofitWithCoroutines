package com.mcbath.retrofitwithcoroutines.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.mcbath.retrofitwithcoroutines.Resource
import com.mcbath.retrofitwithcoroutines.data.MainRepository
import kotlinx.coroutines.Dispatchers

/*The getUsers function of the MainRepository class is a suspend function; therefore, only once
the network call (which is run on another thread, in this case, the thread from Dispatchers.IO)
is completed (success or error), the coroutine resumes by emitting the respective value that is
obtained from the network call.*/

/*A LifecycleScope is defined for each Lifecycle object. LifecycleOwner could be an Activity or a
Fragment. Any coroutine launched in this scope is canceled when the Lifecycle is destroyed. This
helps us in avoiding memory leaks.*/

/*Here we have used liveData(Dispatchers.IO). Therefore, the result of the function will be emitted
as Live Data, which can be observed in the view (Activity or Fragment).*/

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    fun getUsers() = liveData(Dispatchers.IO) {
        emit(Resource.loading(Resource.loading(data = null)))
        try {
            emit(Resource.success(data = mainRepository.getUsers()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, msg = exception.message ?: "Error Occurred!"))
        }
    }
}