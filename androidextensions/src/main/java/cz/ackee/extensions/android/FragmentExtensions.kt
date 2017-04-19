package cz.ackee.extensions.android

import android.os.Bundle
import android.support.v4.app.Fragment

/**
 * Extensions for [Fragment] class
 *
 * @author David Bilik [david.bilik@ackee.cz]
 * @since 19/04/2017
 **/

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
