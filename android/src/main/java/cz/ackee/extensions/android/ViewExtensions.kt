package cz.ackee.extensions.android

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.annotation.*
import androidx.annotation.IntRange

// Extensions for [View] class

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

fun View.drawable(@DrawableRes res: Int): Drawable? {
    return context.drawable(res)
}

fun View.tintedDrawable(@DrawableRes drawableId: Int, @ColorRes colorId: Int): Drawable? {
    return context.tintedDrawable(drawableId, colorId)
}

fun View.string(@StringRes res: Int): String {
    return context.string(res)
}

/**
 * Get color from resources with alpha
 */
@ColorInt
@Deprecated(message = "Use new [colorWithOpacity] extension", replaceWith = ReplaceWith("colorWithOpacity(res, alphaPercent)"))
fun View.colorWithAlpha(@ColorRes res: Int, @IntRange(from = 0, to = 100) alphaPercent: Int): Int {
    return colorWithOpacity(res, alphaPercent)
}

/**
 * Get color from resources with applied [opacity]
 */
@ColorInt
fun View.colorWithOpacity(@ColorRes res: Int, @IntRange(from = 0, to = 100) opacity: Int): Int {
    return context.colorWithOpacity(res, opacity)
}

/**
 * Get color state list from resources
 */
fun View.colors(@ColorRes stateListRes: Int): ColorStateList? {
    return context.colors(stateListRes)
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
fun View.attrDrawable(attr: Int): Drawable? {
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
 * View artificial attribute that sets compound left drawable resource
 */
var TextView.drawableLeftResource: Int
    get() = throw IllegalAccessException("Property drawableLeftResource only as setter")
    set(value) {
        drawableLeft = context.drawable(value)
    }

/**
 * View artificial attribute that sets compound right drawable resource
 */
var TextView.drawableRightResource: Int
    get() = throw IllegalAccessException("Property drawableRightResource only as setter")
    set(value) {
       drawableRight = context.drawable(value)
    }

/**
 * View artificial attribute that sets compound top drawable resource
 */
var TextView.drawableTopResource: Int
    get() = throw IllegalAccessException("Property drawableTopResource only as setter")
    set(value) {
        drawableTop = context.drawable(value)
    }

/**
 * View artificial attribute that sets compound bottom drawable resource
 */
var TextView.drawableBottomResource: Int
    get() = throw IllegalAccessException("Property drawableBottomResource only as setter")
    set(value) {
       drawableBottom = context.drawable(value)
    }

/**
 * View artificial attribute that sets compound left drawable
 */
var TextView.drawableLeft: Drawable?
    get() = throw IllegalAccessException("Property drawableLeft only as setter")
    set(value) {
        val drawables = compoundDrawables
        setCompoundDrawablesWithIntrinsicBounds(value, drawables[1], drawables[2], drawables[3])
    }

/**
 * View artificial attribute that sets compound right drawable
 */
var TextView.drawableRight: Drawable?
    get() = throw IllegalAccessException("Property drawableRight only as setter")
    set(value) {
        val drawables = compoundDrawables
        setCompoundDrawablesWithIntrinsicBounds(drawables[0], drawables[1], value, drawables[3])
    }

/**
 * View artificial attribute that sets compound top drawable
 */
var TextView.drawableTop: Drawable?
    get() = throw IllegalAccessException("Property drawableTop only as setter")
    set(value) {
        val drawables = compoundDrawables
        setCompoundDrawablesWithIntrinsicBounds(drawables[0], value, drawables[2], drawables[3])
    }

/**
 * View artificial attribute that sets compound bottom drawable
 */
var TextView.drawableBottom: Drawable?
    get() = throw IllegalAccessException("Property drawableBottom only as setter")
    set(value) {
        val drawables = compoundDrawables
        setCompoundDrawablesWithIntrinsicBounds(drawables[0], drawables[1], drawables[2], value)
    }

/**
 * Inflate [layout] into this ViewGroup
 */
fun ViewGroup.inflate(@LayoutRes layout: Int, attachToParent: Boolean = true) {
    return context.inflate(layout, this, attachToParent)
}
