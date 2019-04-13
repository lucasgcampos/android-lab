package lucascampos.labs.test.service

import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CallMock<T> private constructor(private val response: T? = null, private val error: Throwable? = null) : Call<T> {

    companion object {
        fun <T> success(response: T) = CallMock(response = response)
        fun <T> error(error: Throwable) = CallMock<T>(error = error)
    }

    override fun enqueue(callback: Callback<T>) {
        error?.let { callback.onFailure(this, error) }
        response?.let { callback.onResponse(this, Response.success(response)) }

    }

    override fun isExecuted(): Boolean {
        return false
    }

    override fun clone(): Call<T> {
        return this
    }

    override fun isCanceled(): Boolean {
        return false
    }

    override fun cancel() {

    }

    override fun request(): Request {
        return Request.Builder().build()
    }

    override fun execute(): Response<T> {
        return Response.success(response)
    }

}
