package cz.ackee.extensions.android

import android.content.Context
import android.graphics.Color
import android.graphics.Point
import android.graphics.drawable.Drawable
import android.os.Build
import android.support.annotation.*
import android.support.annotation.IntRange
import android.support.v4.content.ContextCompat
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.WindowManager


/**
 * Extensions to context class
 *
 * @author David Bilik [david.bilik@ackee.cz]
 * @since 19/04/2017
 **/

@ColorInt
fun Context.color(@ColorRes res: Int): Int {
    return ContextCompat.getColor(this, res)
}

fun Context.drawable(@DrawableRes res: Int): Drawable {
    return ContextCompat.getDrawable(this, res)
}

fun Context.string(@StringRes res: Int): String {
    return getString(res)
}

/**
 * Get color from resources with alpha
 */
@ColorInt
fun Context.colorWithAlpha(@ColorRes res: Int, @IntRange(from = 0, to = 100) alphaPercent: Int): Int {
    val color = color(res)
    return Color.argb((alphaPercent / 100f * 255).toInt(), Color.red(color), Color.green(color), Color.blue(color))
}


internal fun Context.attribute(value: Int): TypedValue {
    var ret = TypedValue()
    theme.resolveAttribute(value, ret, true)
    return ret
}

/**
 * Get dimension defined by attribute [attr]
 */
fun Context.attrDimen(attr: Int): Int {
    return TypedValue.complexToDimensionPixelSize(attribute(attr).data, resources.displayMetrics)
}

/**
 * Get drawable defined by attribute [attr]
 */
fun Context.attrDrawable(attr: Int): Drawable {
    val a = theme.obtainStyledAttributes(intArrayOf(attr))
    val attributeResourceId = a.getResourceId(0, 0)
    a.recycle()
    return drawable(attributeResourceId)
}

/**
 * Inflater layout defined by [res] into view group [parent]. Optionaly attach view to parent with [attachView] attribute
 */
fun Context.inflate(@LayoutRes res: Int, parent: ViewGroup, attachView: Boolean = true) {
    LayoutInflater.from(this).inflate(res, parent, attachView)
}

/**
 * Get screen width
 */
fun Context.screenWidth(): Int {
    return getDisplaySize().x
}

/**
 * Get screen height
 */
fun Context.screenHeight(): Int {
    return getDisplaySize().y
}


/**
 * Get status bar height
 * @param restrictToLollipop indicator if status bar height resource should be lookup only on versions higher than Lollipop
 */
fun Context.statusBarHeight(restrictToLollipop: Boolean = true): Int {
    var result = 0
    val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
    if (resourceId > 0 && (!restrictToLollipop || (restrictToLollipop && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP))) {
        result = resources.getDimensionPixelSize(resourceId)
    }
    return result
}

private fun Context.getDisplaySize(): Point {
    val display = (getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay
    val size = Point()
    display.getSize(size)
    return size
}
