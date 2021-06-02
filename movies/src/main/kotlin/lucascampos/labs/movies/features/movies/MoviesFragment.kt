package lucascampos.labs.movies.features.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ViewFlipper
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import lucascampos.labs.core.decorators.DividerGridItemDecoration
import lucascampos.labs.core.extensions.observe
import lucascampos.labs.core.viewmodel.factoryViewModel
import lucascampos.labs.movies.MovieApi
import lucascampos.labs.movies.MovieViewModel
import lucascampos.labs.movies.R
import lucascampos.labs.movies.models.Movie

class MoviesFragment : Fragment() {

    private val viewModel by factoryViewModel(MovieViewModel::class, MovieApi::class)

    private val viewFlipper by lazy { view?.findViewById<ViewFlipper>(R.id.view_flipper) }
    private val recyclerView by lazy { view?.findViewById<RecyclerView>(R.id.recycler_view) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpViewModel()
    }

    private fun setUpViewModel() {
        viewModel.run {
            movies.observe(viewLifecycleOwner) { setUpRecyclerView(it.results, margin = 16) }
            viewState.observe(viewLifecycleOwner) { viewFlipper?.displayedChild = it.index }

            fetchMovies()
        }
    }

    private fun setUpRecyclerView(results: List<Movie>, margin : Int) {
        val marginBetweenItems = (resources.displayMetrics.density * margin).toInt()

        recyclerView?.run {
            layoutManager = GridLayoutManager(context, 2)
            adapter = MovieAdapter().apply { movies = results }
            addItemDecoration(DividerGridItemDecoration(marginBetweenItems))
        }
    }
}
