package io.github.ackeecz.extensions.rxjava2

import io.reactivex.disposables.Disposable

// Extensions for RxJava2

/**
 * Safely dispose = if not null and not already disposed
 */
fun Disposable?.safeDispose() {
    if (this?.isDisposed == false) {
        dispose()
    }
}
