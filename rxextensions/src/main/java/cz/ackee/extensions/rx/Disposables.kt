package cz.ackee.extensions.rx

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Extensions for RxJava2
 **/

/**
 * Safely dispose = if not null and not already disposed
 */
fun Disposable?.safeDispose() {
    if (this?.isDisposed == false) {
        dispose()
    }
}

/**
 * Overloaded operator to allow adding [Disposable] to [CompositeDisposable] via + sign
 */
operator fun CompositeDisposable.plus(disposable: Disposable): CompositeDisposable {
    this.add(disposable)
    return this
}
