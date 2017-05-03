package cz.ackee.extensions.anko

import android.support.design.widget.BottomNavigationView
import android.support.design.widget.TextInputEditText
import android.support.v7.widget.AppCompatCheckBox
import android.support.v7.widget.AppCompatEditText
import android.support.v7.widget.AppCompatRadioButton
import android.support.v7.widget.AppCompatSeekBar
import android.view.ViewGroup
import android.view.ViewManager
import android.widget.LinearLayout
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.custom.ankoView

/**
 * Extensions to Anko DSL
 *
 * @author David Bilik [david.bilik@ackee.cz]
 * @since 19/04/2017
 **/


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

