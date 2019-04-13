package lucascampos.labs.movies.models

import com.google.gson.annotations.SerializedName

class DiscoverResponse(
    @SerializedName("results") val results: List<Movie>
)

class Movie(
    @SerializedName("title") val title: String,
    @SerializedName("poster_path") val poster: String
)
