package cz.ackee.extensions.rx

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Extensions for RxJava2
 *
 * @author David Bilik [david.bilik@ackee.cz]
 * @since 19/04/2017
 **/

fun <T> Observable<T>.observeOnMainThread(): Observable<T> {
    return this.observeOn(AndroidSchedulers.mainThread())
}

fun <T> Observable<T>.subscribeOnIO(): Observable<T> {
    return this.subscribeOn(Schedulers.io())
}

fun <T> Observable<T>.subscribeOnNewThread(): Observable<T> {
    return this.subscribeOn(Schedulers.newThread())
}

fun <T> Observable<T>.subscribeOnComputation(): Observable<T> {
    return this.subscribeOn(Schedulers.computation())
}

/**
 * Safely dispose = if not null and not already disposed
 */
fun Disposable?.safeDispose() {
    if (this != null && !this.isDisposed) {
        dispose()
    }
}

