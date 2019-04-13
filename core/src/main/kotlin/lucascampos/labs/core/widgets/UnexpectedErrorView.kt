package lucascampos.labs.core.widgets

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import lucascampos.labs.core.R
import lucascampos.labs.core.extensions.inflate

class UnexpectedErrorView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    init { inflate(R.layout.view_error_unexpected, true) }
}
