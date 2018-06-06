package cz.ackee.extensions.anko

import android.content.Context
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.TextInputEditText
import android.support.v7.widget.*
import android.view.View
import android.view.ViewGroup
import android.view.ViewManager
import android.widget.LinearLayout
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.custom.ankoView

// Extensions to Anko DSL

/**
 * Anko extensions for [TextInputEditText]
 */
inline fun ViewManager.textInputEditText() = textInputEditText {}

inline fun ViewManager.textInputEditText(theme: Int = 0, init: TextInputEditText.() -> Unit) = ankoView(::TextInputEditText, theme, init)

/**
 * Get Anko context from view group
 */
val ViewGroup.ankoContext
    get() = AnkoContext.Companion.create(context, this)

/**
 * Fixed cardView extension to Anko. CardView from Anko does not have lparams extensions
 * and crashes when defining some. This solution uses same lparams as FrameLayout
 */
inline fun ViewManager.cardView(theme: Int = 0): CardView = cardView(theme) {}

inline fun ViewManager.cardView(theme: Int = 0, init: _CardView.() -> Unit): CardView {
    return ankoView(::_CardView, theme, init)
}

open class _CardView(ctx: Context) : CardView(ctx) {
    private val defaultInit: Any.() -> Unit = {}

    fun <T : View> T.lparams(
            c: android.content.Context?,
            attrs: android.util.AttributeSet?,
            init: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T : View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(width, height)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T : View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            gravity: Int,
            init: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(width, height, gravity)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T : View> T.lparams(
            source: android.view.ViewGroup.LayoutParams?,
            init: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T : View> T.lparams(
            source: android.view.ViewGroup.MarginLayoutParams?,
            init: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }
}
