package lucascampos.labs.core.extensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun <T> LiveData<T>.observe(owner: LifecycleOwner, func: (T) -> Unit) {
    observe(owner, Observer { data ->
        data?.let {
           func(it)
        }
    })
}
