package lucascampos.labs.movies

import androidx.lifecycle.MutableLiveData
import lucascampos.labs.core.viewmodel.BaseViewModel
import lucascampos.labs.movies.models.DiscoverResponse

class MovieViewModel(private val api: MovieApi) : BaseViewModel() {

    val movies = MutableLiveData<DiscoverResponse>()

    fun fetchMovies() {
        if (movies.value == null) {
            makeRequest(api.fetchMovies()) {
                movies.postValue(it)
            }
        }
    }
}
