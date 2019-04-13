package lucascampos.labs.core.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import lucascampos.labs.core.service.RetrofitConfig
import kotlin.reflect.KClass

private class ViewModelFactory(private val api: Class<*>) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(viewModelClass: Class<T>): T {
        return viewModelClass
            .getConstructor(api)
            .newInstance(RetrofitConfig.createService(api))
    }
}

fun <T : ViewModel> ViewModelStoreOwner.factoryViewModel(viewModelClass: KClass<T>, api: KClass<*>) =
    lazy { ViewModelProvider(this, ViewModelFactory(api.java)).get(viewModelClass.java) }
