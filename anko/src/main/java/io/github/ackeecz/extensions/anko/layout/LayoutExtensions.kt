package io.github.ackeecz.extensions.anko.layout

import android.app.Activity
import android.content.Context
import android.view.ViewGroup
import android.view.ViewManager
import org.jetbrains.anko.AnkoException
import org.jetbrains.anko.internals.AnkoInternals

/**
 * Automatically instantiates ViewLayout with no constructor parameter or single Context parameter
 * and adds the layout to the ViewManager's view hierarchy
 */
inline fun <reified T : ViewLayout> ViewManager.customLayout(theme: Int = 0, init: T.() -> Unit = {}): T =
    ankoLayout({ ctx -> instantiateLayout(ctx, this as ViewGroup?, T::class.java) }, theme) { init() }

inline fun <reified T : ViewLayout> Context.customLayout(theme: Int = 0, init: T.() -> Unit = {}): T =
    ankoLayout({ ctx -> instantiateLayout(ctx, null, T::class.java) }, theme) { init() }

inline fun <reified T : ViewLayout> Activity.customLayout(theme: Int = 0, init: T.() -> Unit = {}): T =
    ankoLayout({ ctx -> instantiateLayout(ctx, this.window.decorView as ViewGroup?, T::class.java) }, theme) { init() }

/**
 * Adds layout's view to ViewManager's view hierarchy and returns it. Useful only if the layout
 * has custom constructor and cannot be created with default [Context] parameter.
 */
inline fun <reified T : ViewLayout> ViewManager.customLayout(layout: T, init: T.() -> Unit = {}): T {
    return layout.apply {
        view
        init()
        AnkoInternals.addView(this@customLayout, view)
    }
}

/**
 * Internal. Use [ViewManager.customLayout] instead.
 */
inline fun <T : ViewLayout> ViewManager.ankoLayout(factory: (ctx: Context) -> T, theme: Int, init: T.() -> Unit): T {
    val ctx = AnkoInternals.wrapContextIfNeeded(AnkoInternals.getContext(this), theme)
    return factory(ctx).apply {
        view
        init()
        AnkoInternals.addView(this@ankoLayout, view)
    }
}

/**
 * Internal. Use [Context.customLayout] instead.
 */
inline fun <T : ViewLayout> Context.ankoLayout(factory: (ctx: Context) -> T, theme: Int, init: T.() -> Unit): T {
    val ctx = AnkoInternals.wrapContextIfNeeded(this, theme)
    return factory(ctx).apply {
        view
        init()
        AnkoInternals.addView(this@ankoLayout, view)
    }
}

/**
 * Internal. Use [Activity.customLayout] instead.
 */
inline fun <T : ViewLayout> Activity.ankoLayout(factory: (ctx: Context) -> T, theme: Int, init: T.() -> Unit): T {
    val ctx = AnkoInternals.wrapContextIfNeeded(this, theme)
    return factory(ctx).apply {
        view
        init()
        AnkoInternals.addView(this@ankoLayout, view)
    }
}

/**
 * Internal. Cannot be marked as private because it is used in other public inline methods.
 *
 * Instantiates a subclass of [ViewLayout].
 */
fun <T : ViewLayout> instantiateLayout(ctx: Context, parent: ViewGroup?, layoutClass: Class<T>): T {
    try {
        return layoutClass.getConstructor(Context::class.java).newInstance(ctx)
    } catch (e: NoSuchMethodException) {
        if (parent != null) {
            try {
                return layoutClass.getConstructor(ViewGroup::class.java).newInstance(parent)
            } catch (e: NoSuchMethodException) {
            }
        }
    }
    throw AnkoException("Can't initiate View of class ${layoutClass.name}: can't find proper constructor")
}
