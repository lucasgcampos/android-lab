package lucascampos.labs.core.widgets

import android.content.Context
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.widget.TextView
import androidx.test.core.app.ApplicationProvider
import lucascampos.labs.core.R
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class UnexpectedErrorViewTest {

    private lateinit var sut: UnexpectedErrorView

    private val context = ApplicationProvider.getApplicationContext<Context>()

    private val icon: TextView
        get() = sut.findViewById(R.id.icon)

    private val message: TextView
        get() = sut.findViewById(R.id.message)

    @Test
    fun givenUnexpectedErrorView_WhenCreate_ThenMessageShouldBeCorrect() {
        sut = UnexpectedErrorView(context)

        assertEquals(context.getString(R.string.view_error_unexpected_message), message.text)
    }

    @Test
    fun givenUnexpectedErrorView_WhenCreate_ThenIconShouldBeCorrect() {
        sut = UnexpectedErrorView(context)

        val expected = context.getDrawable(R.drawable.bg_circle_red)!!.toGradient()
        val sutBackground = icon.background.toGradient()

        assertEquals("X", icon.text)
        assertEquals(expected.color, sutBackground.color)
        assertEquals(expected.shape, sutBackground.shape)
    }

    private fun Drawable.toGradient() = this as GradientDrawable

}