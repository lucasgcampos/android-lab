package lucascampos.labs.core.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

abstract class BaseViewModel : ViewModel() {

    val viewState = MutableLiveData<ViewState>()
    val defaultError = MutableLiveData<Throwable>()

    fun <T> makeRequest(request: Call<T>, func: (T) -> Unit) {
        viewState.postValue(ViewState.LOADING)

        request.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                viewState.postValue(ViewState.SUCCESS)
                func(response.body()!!)
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                viewState.postValue(ViewState.ERROR)
                defaultError.postValue(t)
            }
        })
    }
}

enum class ViewState(val index: Int) {
    SUCCESS(0),
    LOADING(1),
    ERROR(2)
}
