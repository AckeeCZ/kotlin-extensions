package io.github.ackeecz.extensions.android

import android.graphics.Color
import androidx.annotation.ColorInt
import androidx.annotation.IntRange
import java.util.Date

// Useful functions not related to any class

fun now() = Date()

fun nowMillis() = System.currentTimeMillis()

fun Int.toBoolean() = this > 0

fun Boolean.toInt() = if (this) 1 else 0

/**
 * Assume that this Int is a color and apply [opacity] to it.
 */
@ColorInt
fun Int.withOpacity(@IntRange(from = 0, to = 100) opacity: Int): Int {
    return Color.argb((opacity / 100f * 255).toInt(), Color.red(this), Color.green(this), Color.blue(this))
}
