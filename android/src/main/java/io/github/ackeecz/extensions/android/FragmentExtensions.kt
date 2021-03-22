package io.github.ackeecz.extensions.android

import android.os.Bundle
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.IntRange
import androidx.fragment.app.Fragment

// Extensions for [Fragment] class

/**
 * Set arguments to fragment and return current instance
 */
inline fun <reified T : Fragment> T.withArguments(args: Bundle): T {
    this.arguments = args
    return this
}

/**
 * Set target fragment with request code and return current instance
 */
fun Fragment.withTargetFragment(fragment: Fragment, reqCode: Int): Fragment {
    setTargetFragment(fragment, reqCode)
    return this
}

/**
 * Get color from resource with fragment context.
 */
fun Fragment.color(@ColorRes res: Int) = context!!.color(res)


/**
 * Get color from resource with fragment context and apply [opacity] to it.
 */
@ColorInt
fun Fragment.colorWithOpacity(@ColorRes res: Int, @IntRange(from = 0, to = 100) opacity: Int) = context!!.colorWithOpacity(res, opacity)

/**
 * Open Play Store with the application ID from provided context. Return true if the intent can be
 * and will be handled, false otherwise.
 */
fun Fragment.openPlayStore() = requireContext().openPlayStore()
