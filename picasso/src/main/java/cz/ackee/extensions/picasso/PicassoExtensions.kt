package cz.ackee.extensions.picasso

import android.widget.ImageView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

// Extensions for Picasso

/**
 * Load url to ImageView and use optional callback or noFade to disable fade animation
 */
fun ImageView.loadUrl(url: String, noFade: Boolean = false, callback: Callback? = null) {
    Picasso.get()
            .load(url)
            .apply {
                if (noFade) {
                    noFade()
                }
            }
            .into(this, callback)
}