package cz.ackee.extensions.picasso

import android.widget.ImageView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

// Extensions for Picasso

/**
 * Load url to ImageView and use optional callback
 */
fun ImageView.loadUrl(url: String, callback: Callback? = null) {
    Picasso.with(context).load(url).into(this, callback)
}