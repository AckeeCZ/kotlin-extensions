package io.github.ackeecz.extensions.android


// Extensions to collections

/**
 * Check if this collection is null or empty
 */
fun Collection<*>?.isNullOrEmpty(): Boolean {
    return this == null || this.isEmpty()
}
