package cz.ackee.extensions.android

/**
 * Extensions to collections
 *
 * @author David Bilik [david.bilik@ackee.cz]
 * @since 19/04/2017
 **/

/**
 * Check if this collection is null or empty
 */
fun Collection<*>?.isNullOrEmpty(): Boolean {
    return this == null || this.isEmpty()
}