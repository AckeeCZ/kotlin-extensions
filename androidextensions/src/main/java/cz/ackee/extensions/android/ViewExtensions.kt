package cz.ackee.extensions.android

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.support.annotation.*
import android.support.annotation.IntRange
import android.support.v4.content.ContextCompat
import android.util.TypedValue
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.TextView

/**
 * Extensions for [View] class
 *
 * @author David Bilik [david.bilik@ackee.cz]
 * @since 19/04/2017
 **/

var View.visible: Boolean
    set(value) {
        visibility = if (value) View.VISIBLE else GONE
    }
    get() = visibility == View.VISIBLE


fun View.hideIme() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}


@ColorInt
fun View.color(@ColorRes res: Int): Int {
    return context.color(res)
}

fun View.drawable(@DrawableRes res: Int): Drawable {
    return context.drawable(res)
}

fun View.string(@StringRes res: Int): String {
    return context.string(res)
}

fun View.dimen(@DimenRes res: Int): Int {
    return context.dimen(res)
}

/**
 * Get color from resources with alpha
 */
@ColorInt
fun View.colorWithAlpha(@ColorRes res: Int, @IntRange(from = 0, to = 100) alphaPercent: Int): Int {
    return context.colorWithAlpha(res, alphaPercent)
}


/**
 * Get dimension defined by attribute [attr]
 */
fun View.attrDimen(attr: Int): Int {
    return context.attrDimen(attr)
}

/**
 * Get drawable defined by attribute [attr]
 */
fun View.attrDrawable(attr: Int): Drawable {
    return context.attrDrawable(attr)
}


/**
 * Get bitmap representation of view
 */
fun View.asBitmap(): Bitmap {
    val b = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
    val c = Canvas(b)
    layout(left, top, right, bottom)
    draw(c)
    return b
}


/**
 * View artificial attribute that sets compound left drawable
 */
var TextView.drawableLeft: Int
    get() = throw IllegalAccessException("Property drawableLeft only as setter")
    set(value) {
        val drawables = compoundDrawables
        setCompoundDrawablesWithIntrinsicBounds(context.drawable(value), drawables[1], drawables[2], drawables[3])
    }


/**
 * View artificial attribute that sets compound right drawable
 */
var TextView.drawableRight: Int
    get() = throw IllegalAccessException("Property drawableRight only as setter")
    set(value) {
        val drawables = compoundDrawables
        setCompoundDrawablesWithIntrinsicBounds(drawables[0], drawables[1], context.drawable(value), drawables[3])
    }


/**
 * View artificial attribute that sets compound top drawable
 */
var TextView.drawableTop: Int
    get() = throw IllegalAccessException("Property drawableTop only as setter")
    set(value) {
        val drawables = compoundDrawables
        setCompoundDrawablesWithIntrinsicBounds(drawables[0], context.drawable(value), drawables[2], drawables[3])
    }


/**
 * View artificial attribute that sets compound bottom drawable
 */
var TextView.drawableBottom: Int
    get() = throw IllegalAccessException("Property drawableBottom only as setter")
    set(value) {
        val drawables = compoundDrawables
        setCompoundDrawablesWithIntrinsicBounds(drawables[0], drawables[1], drawables[2], context.drawable(value))
    }


/**
 * Inflate [layout] into this ViewGroup
 */
fun ViewGroup.inflate(@LayoutRes layout: Int, attachToParent: Boolean = true) {
    return context.inflate(layout, this, attachToParent)
}