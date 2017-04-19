package cz.ackee.extensions.recyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView

/**
 * Extensions for [RecyclerView]
 *
 * @author David Bilik [david.bilik@ackee.cz]
 * @since 19/04/2017
 **/


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
val RecyclerView.ViewHolder.context: Context get() {
    return itemView.context
}
