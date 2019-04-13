package lucascampos.labs.movies.widgets

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import lucascampos.labs.core.extensions.inflate
import lucascampos.labs.core.extensions.loadUrl
import lucascampos.labs.movies.R
import lucascampos.labs.movies.models.Movie

class MovieItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val nameView by lazy { findViewById<TextView>(R.id.name) }
    private val posterView by lazy { findViewById<ImageView>(R.id.poster) }

    init {
        orientation = VERTICAL
        inflate(R.layout.view_movie_item, true)
    }

    fun setup(movie: Movie) {
        nameView.text = movie.title
        posterView.loadUrl(movie.poster)
    }
}
