package cz.ackee.extensions.android

import java.text.Normalizer
import java.util.regex.Pattern

// Extensions for String class

/**
 * Normalize string - convert to lowercase, replace diacritics and trim trailing whitespaces
 */
fun String.normalize(): String {
    return Normalizer.normalize(toLowerCase(), Normalizer.Form.NFD)
            .replace("[\\p{InCombiningDiacriticalMarks}]".toRegex(), "").trim()
}
