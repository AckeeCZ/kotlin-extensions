package cz.ackee.extensions.anko.layout

import android.content.Context
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext

/**
 * Class representing layout created with anko
 */
abstract class ViewLayout(val context: Context) : AnkoComponent<Context> {

    constructor(parent: ViewGroup) : this(parent.context)

    val view: View by lazy { createView(AnkoContext.create(context)) }

    fun view(block: View.() -> Unit = {}) = view.apply(block)
}