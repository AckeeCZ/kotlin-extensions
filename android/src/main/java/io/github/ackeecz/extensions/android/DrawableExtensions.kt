package io.github.ackeecz.extensions.android

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.RippleDrawable
import android.graphics.drawable.StateListDrawable
import androidx.annotation.ColorInt
import androidx.core.graphics.ColorUtils

// Extensions for creating drawables and other drawable-related helpers

/**
 * Create a drawable programmatically with optional properties. When [isButton] defined as
 * true result is a drawable with ripple effect.
 *
 * @param color - color of a drawable
 * @param isButton - wheter drawable should respond to pressed state
 * @param checkedColor - color of checked state
 * @param pressedColor - color of pressed state
 * @param focusedColor - color of focused state
 * @param disabledColor - color of a disabled state
 * @param mask - mask drawable applied on a result ripple drawable.
 * @param radius - corner radius in px
 * @param strokeColor - color of a stroke effect
 * @param strokeWidth - width of a stroke effect
 * @param topLeftRadius - top left corner radius
 * @param topRightRadius - top right corner radius
 * @param bottomLeftRadius - bottom left corner radius
 * @param bottomRightRadius - bottom right corner radius
 */
fun backgroundDrawable(
    @ColorInt color: Int,
    isButton: Boolean = false,
    @ColorInt checkedColor: Int = color,
    @ColorInt pressedColor: Int = color.toPressedColor(),
    @ColorInt focusedColor: Int = color,
    @ColorInt disabledColor: Int = color,
    mask: Drawable? = null,
    radius: Number = 0f,
    strokeColor: Int = Color.TRANSPARENT,
    strokeWidth: Int = 0,
    topLeftRadius: Number = 0f,
    topRightRadius: Number = 0f,
    bottomLeftRadius: Number = 0f,
    bottomRightRadius: Number = 0f
): Drawable {
    val baseDrawable = StateListDrawable().apply {
        addState(intArrayOf(-android.R.attr.state_enabled), GradientDrawable().apply {
            setCornerRadius(radius, topLeftRadius, topRightRadius, bottomLeftRadius, bottomRightRadius)
            setColor(disabledColor)
            setStroke(strokeWidth, strokeColor)
        })
        addState(intArrayOf(android.R.attr.state_focused), GradientDrawable().apply {
            setCornerRadius(radius, topLeftRadius, topRightRadius, bottomLeftRadius, bottomRightRadius)
            setColor(focusedColor)
            setStroke(strokeWidth, strokeColor)
        })
        addState(intArrayOf(android.R.attr.state_checked), GradientDrawable().apply {
            setCornerRadius(radius, topLeftRadius, topRightRadius, bottomLeftRadius, bottomRightRadius)
            setColor(checkedColor)
            setStroke(strokeWidth, strokeColor)
        })
        addState(intArrayOf(), GradientDrawable().apply {
            setCornerRadius(radius, topLeftRadius, topRightRadius, bottomLeftRadius, bottomRightRadius)
            setColor(color)
            setStroke(strokeWidth, strokeColor)
        })
    }

    if (!isButton) return baseDrawable

    // set pressed state only if isButton = true
    return RippleDrawable(ColorStateList.valueOf(pressedColor), baseDrawable, mask)
}

private fun Int.toPressedColor(): Int {
    return if (isDarkColor(this)) {
        toLighterColor()
    } else {
        toDarkerColor()
    }
}

private fun isDarkColor(color: Int): Boolean {
    return ColorUtils.calculateLuminance(color) < 0.15
}

/**
 * Convert color to lighter shade
 */
fun Int.toLighterColor(): Int {
    val hsv = floatArrayOf(0f, 0f, 0f)
    Color.colorToHSV(this, hsv)
    hsv[2] = 0.2f + 0.8f * hsv[2];
    return Color.HSVToColor(hsv)
}

/**
* Convert color to darker shade
*/
fun Int.toDarkerColor(): Int {
    val hsv = floatArrayOf(0f, 0f, 0f)
    Color.colorToHSV(this, hsv)
    hsv[2] *= 0.8f
    return Color.HSVToColor(hsv)
}

private fun GradientDrawable.setCornerRadius(
    radius: Number,
    topLeftRadius: Number = 0f,
    topRightRadius: Number = 0f,
    bottomLeftRadius: Number = 0f,
    bottomRightRadius: Number = 0f
) {
    if (radius != 0f) {
        cornerRadius = radius.toFloat()
    } else {
        cornerRadii = floatArrayOf(
            topLeftRadius.toFloat(), topLeftRadius.toFloat(),
            topRightRadius.toFloat(), topRightRadius.toFloat(),
            bottomRightRadius.toFloat(), bottomRightRadius.toFloat(),
            bottomLeftRadius.toFloat(), bottomLeftRadius.toFloat()
        )
    }
}

/**
 * Create a [ColorStateList] programmatically
 */
fun colorStateList(
    @ColorInt normalColor: Int,
    @ColorInt checkedColor: Int? = null,
    @ColorInt selectedColor: Int? = null,
    @ColorInt disabledColor: Int? = null,
    @ColorInt pressedColor: Int? = null,
    @ColorInt focusedColor: Int? = null
): ColorStateList {
    val states = mapOf(
        intArrayOf(-android.R.attr.state_enabled) to disabledColor,
        intArrayOf(android.R.attr.state_pressed) to pressedColor,
        intArrayOf(android.R.attr.state_checked) to checkedColor,
        intArrayOf(android.R.attr.state_selected) to selectedColor,
        intArrayOf(android.R.attr.state_focused) to focusedColor,
        intArrayOf() to normalColor
    ).filterValues { it != null }
    return ColorStateList(states.keys.toTypedArray(), states.values.map { it!!.toInt() }.toIntArray())
}
