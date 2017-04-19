package cz.ackee.extensions.android

import java.text.Normalizer
import java.util.regex.Pattern

/**
 * Extensions for String class
 *
 * @author David Bilik [david.bilik@ackee.cz]
 * @since 19/04/2017
 **/

/**
 * Normalize string - convert to lowercase, replace diacritics and trim trailing whitespaces
 */
fun String.normalize(): String {
    return Normalizer.normalize(toLowerCase(), Normalizer.Form.NFD)
            .replace("[\\p{InCombiningDiacriticalMarks}]".toRegex(), "").trim()
}
