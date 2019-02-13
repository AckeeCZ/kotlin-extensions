package cz.ackee.extensions.recyclerview

import android.content.Context
import androidx.recyclerview.widget.RecyclerView

// Extensions for [RecyclerView]

fun RecyclerView.onItemClick(onItemClick: (Int) -> Unit) {
    ItemClickSupport
        .addTo(this)
        .onItemClick(onItemClick)
}

fun RecyclerView.onItemLongClick(onItemLongClick: (Int) -> Boolean) {
    ItemClickSupport
        .addTo(this)
        .onLongItemClick(onItemLongClick)
}

/**
 * Context getter extension for ViewHolder
 */
val RecyclerView.ViewHolder.context: Context
    get() {
        return itemView.context
    }
