package io.github.ackeecz.extensions.android

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.content.res.Configuration
import android.graphics.Point
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.WindowManager
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.IntRange
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat

// Extensions to context class

@ColorInt
fun Context.color(@ColorRes res: Int): Int {
    return ContextCompat.getColor(this, res)
}

fun Context.drawable(@DrawableRes res: Int): Drawable? {
    return ContextCompat.getDrawable(this, res)
}

fun Context.tintedDrawable(@DrawableRes drawableId: Int, @ColorRes colorId: Int): Drawable? {
    val tint: Int = color(colorId)
    val drawable = drawable(drawableId)
    drawable?.mutate()
    drawable?.let {
        it.mutate()
        DrawableCompat.setTint(it, tint)
    }
    return drawable
}

fun Context.string(@StringRes res: Int): String {
    return getString(res)
}

/**
 * Get color from resources with applied [opacity]
 */
@ColorInt
fun Context.colorWithOpacity(@ColorRes res: Int, @IntRange(from = 0, to = 100) opacity: Int): Int {
    return color(res).withOpacity(opacity)
}

fun Context.colors(@ColorRes stateListRes: Int): ColorStateList? {
    return ContextCompat.getColorStateList(this, stateListRes)
}

internal fun Context.attribute(value: Int): TypedValue {
    val ret = TypedValue()
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
fun Context.attrDrawable(attr: Int): Drawable? {
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

/**
 * Get whether dark mode is enabled or not
 */
fun Context.isDarkModeOn(): Boolean {
    val currentNightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
    return currentNightMode == Configuration.UI_MODE_NIGHT_YES
}

/**
 * Open Play Store with the application ID from provided context. Return true if the intent can be
 * and will be handled, false otherwise.
 */
fun Context.openPlayStore(): Boolean {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$packageName"))
    val availableActivities = packageManager.queryIntentActivities(intent, 0);

    return if (availableActivities.isNotEmpty()) {
        startActivity(intent)
        true
    } else {
        false
    }
}

@Suppress("DEPRECATION")
private fun Context.getDisplaySize(): Point {
     return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
         val windowBounds = (getSystemService(Context.WINDOW_SERVICE) as WindowManager).currentWindowMetrics.bounds
         Point(windowBounds.width(), windowBounds.height())
    } else {
         val display = (getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay
         val size = Point()
         display.getSize(size)
         size
    }
}
