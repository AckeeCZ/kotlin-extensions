package cz.ackee.extensions.android

import android.text.Spannable
import android.text.style.StyleSpan
import androidx.annotation.StyleRes

// Extensions for [Spannable]

/**
 * Highlight substring [query] in this spannable with custom [style]. All occurrences of this substring
 * are stylized
 */
fun Spannable.highlightSubstring(query: String, @StyleRes style: Int): Spannable {
    val spannable = Spannable.Factory.getInstance().newSpannable(this)
    val substrings = query.toLowerCase().split("\\s+".toRegex()).dropLastWhile(String::isEmpty).toTypedArray()
    var lastIndex = 0
    for (i in substrings.indices) {
        do {
            lastIndex = this.toString().toLowerCase().indexOf(substrings[i], lastIndex)
            if (lastIndex != -1) {
                spannable.setSpan(StyleSpan(style), lastIndex, lastIndex + substrings[i].length, Spannable.SPAN_EXCLUSIVE_INCLUSIVE)
                lastIndex++
            }
        } while (lastIndex != -1)
    }
    return spannable
}