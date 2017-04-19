package cz.ackee.extensions.anko

import android.support.design.widget.BottomNavigationView
import android.support.design.widget.TextInputEditText
import android.support.v7.widget.AppCompatCheckBox
import android.support.v7.widget.AppCompatEditText
import android.support.v7.widget.AppCompatRadioButton
import android.support.v7.widget.AppCompatSeekBar
import android.view.ViewManager
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
 * Anko extensions for [AppCompatEditText]
 */
inline fun ViewManager.appcompatEdittext() = appcompatEdittext {}

inline fun ViewManager.appcompatEdittext(theme: Int = 0, init: AppCompatEditText.() -> Unit) = ankoView(::AppCompatEditText, theme, init)

/**
 * Anko extensions for [AppCompatSeekBar]
 */
inline fun ViewManager.appcompatSeekbar() = appcompatSeekbar {}

inline fun ViewManager.appcompatSeekbar(theme: Int = 0, init: AppCompatSeekBar.() -> Unit) = ankoView(::AppCompatSeekBar, theme, init)


/**
 * Anko extensions for [AppCompatRadioButton]
 */
inline fun ViewManager.appcompatRadiobutton() = appcompatRadiobutton {}

inline fun ViewManager.appcompatRadiobutton(theme: Int = 0, init: AppCompatRadioButton.() -> Unit) = ankoView(::AppCompatRadioButton, theme, init)

/**
 * Anko extensions for [AppCompatCheckBox]
 */
inline fun ViewManager.appcompatCheckbox() = appcompatCheckbox {}

inline fun ViewManager.appcompatCheckbox(theme: Int = 0, init: AppCompatCheckBox.() -> Unit) = ankoView(::AppCompatCheckBox, theme, init)

/**
 * Anko extensions for [BottomNavigationView]
 */
inline fun ViewManager.bottomNavigation() = bottomNavigation {}

inline fun ViewManager.bottomNavigation(theme: Int = 0, init: BottomNavigationView.() -> Unit) = ankoView(::BottomNavigationView, theme, init)



