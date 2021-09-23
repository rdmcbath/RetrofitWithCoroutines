package com.mcbath.retrofitwithcoroutines

/*utility class that will be responsible to communicate the current state of Network Call to
the UI Layer.*/

data class Resource<out T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T): Resource<T> = Resource(status = Status.SUCCESS, data = data, message = null)

        fun <T> error(data: T?, msg: String): Resource<T> =
            Resource(status = Status.ERROR, data = data, message = msg)

        fun <T> loading(data: T?): Resource<T> = Resource(status = Status.LOADING, data = data, message = null)
    }
}