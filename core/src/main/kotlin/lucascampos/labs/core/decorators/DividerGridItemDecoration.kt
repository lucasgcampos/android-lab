package lucascampos.labs.core.decorators

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Configure the distance between each element of RecyclerView (vertical and horizontal)
 *
 * @param distance (in pixel)
 */
class DividerGridItemDecoration(private val distance: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)

        parent.clipToPadding = false
        parent.setPadding(0, 0, distance, distance)

        outRect.set(distance, distance, 0, 0)
    }
}
