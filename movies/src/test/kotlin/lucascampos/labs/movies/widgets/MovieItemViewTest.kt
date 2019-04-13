package lucascampos.labs.movies.widgets

import android.widget.TextView
import androidx.test.core.app.ApplicationProvider
import lucascampos.labs.movies.R
import lucascampos.labs.movies.models.Movie
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class MovieItemViewTest {

    private lateinit var view: MovieItemView

    private val name: TextView
        get() = view.findViewById(R.id.name)

    @Test
    fun givenMovieItemView_WhenSetup_ThenTheNameIsSet() {
        view = MovieItemView(ApplicationProvider.getApplicationContext())

        val movie = createMovie()
        view.setup(movie)

        assertEquals(movie.title, name.text.toString())
    }
}

private fun createMovie() = Movie(title = "Harry Potter", poster = "")
