package io.github.ackeecz.extensions.epoxy

import android.view.View
import android.view.ViewGroup
import com.airbnb.epoxy.EpoxyModelWithView
import io.github.ackeecz.extensions.anko.layout.ViewLayout

/**
 * Epoxy model with [ViewLayout] implementation
 */
abstract class EpoxyModelWithLayout<T : ViewLayout> : EpoxyModelWithView<View>() {

    abstract fun createViewLayout(parent: ViewGroup): T

    final override fun buildView(parent: ViewGroup): View {
        val layout: T = createViewLayout(parent)
        val view = layout.view
        view.setTag(R.id.epoxy_view_layout, layout)
        return view
    }

    final override fun bind(view: View) {
        super.bind(view)

        @Suppress("UNCHECKED_CAST")
        (view.getTag(R.id.epoxy_view_layout) as T).bind()
    }

    abstract fun T.bind()

    open fun T.unbind() {
    }

    override fun unbind(view: View) {
        super.unbind(view)

        @Suppress("UNCHECKED_CAST")
        (view.getTag(R.id.epoxy_view_layout) as T).unbind()
    }
}
