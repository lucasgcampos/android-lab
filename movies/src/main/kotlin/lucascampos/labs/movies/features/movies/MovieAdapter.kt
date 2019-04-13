package lucascampos.labs.movies.features.movies

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import lucascampos.labs.movies.models.Movie
import lucascampos.labs.movies.widgets.MovieItemView

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    var movies = listOf<Movie>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(MovieItemView(parent.context))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bindView(movies[position])

    override fun getItemCount() = movies.size

    class ViewHolder(private val movieItemView: MovieItemView) : RecyclerView.ViewHolder(movieItemView) {

        fun bindView(movie: Movie) = movieItemView.setup(movie)
    }
}
