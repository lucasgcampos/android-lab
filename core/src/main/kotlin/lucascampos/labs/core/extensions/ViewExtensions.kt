package lucascampos.labs.core.extensions

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.LayoutRes
import com.bumptech.glide.Glide

fun ImageView.loadUrl(url: String) {
    Glide.with(this).load("https://image.tmdb.org/t/p/w500/$url").into(this)
}

fun ViewGroup.inflate(@LayoutRes layout: Int, attachToRoot: Boolean = false) {
    LayoutInflater.from(context).inflate(layout, this, attachToRoot)
}

