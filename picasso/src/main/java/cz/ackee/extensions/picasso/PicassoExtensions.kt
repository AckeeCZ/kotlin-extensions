package cz.ackee.extensions.picasso

import android.widget.ImageView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

// Extensions for Picasso

/**
 * Load url to ImageView and use optional callback or noFade to disable fade animation
 */
fun ImageView.loadUrl(url: String, noFade: Boolean = false, callback: Callback? = null) {
    if (noFade) {
        Picasso.with(context).load(url).noFade().into(this, callback)
    } else {
        Picasso.with(context).load(url).into(this, callback)
    }
}