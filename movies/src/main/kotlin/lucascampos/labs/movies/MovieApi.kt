package lucascampos.labs.movies

import lucascampos.labs.movies.models.DiscoverResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieApi {

    @GET("discover/movie?api_key=${BuildConfig.API_KEY}")
    fun fetchMovies(): Call<DiscoverResponse>
}
