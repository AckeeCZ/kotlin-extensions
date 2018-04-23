package cz.ackee.extensions.android

import java.util.*

// Useful functions not related to any class

fun now() = Date()

fun nowMillis() = System.currentTimeMillis()

fun Int.toBoolean() = this > 0

fun Boolean.toInt() = if (this) 1 else 0