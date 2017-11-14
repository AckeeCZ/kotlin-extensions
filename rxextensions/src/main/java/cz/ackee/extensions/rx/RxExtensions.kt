package cz.ackee.extensions.rx

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
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

fun Completable.observeOnMainThread(): Completable {
    return this.observeOn(AndroidSchedulers.mainThread())
}

fun Completable.subscribeOnIO(): Completable {
    return this.subscribeOn(Schedulers.io())
}

fun Completable.subscribeOnNewThread(): Completable {
    return this.subscribeOn(Schedulers.newThread())
}

fun Completable.subscribeOnComputation(): Completable {
    return this.subscribeOn(Schedulers.computation())
}

fun <T> Maybe<T>.observeOnMainThread(): Maybe<T> {
    return this.observeOn(AndroidSchedulers.mainThread())
}

fun <T> Maybe<T>.subscribeOnIO(): Maybe<T> {
    return this.subscribeOn(Schedulers.io())
}

fun <T> Maybe<T>.subscribeOnNewThread(): Maybe<T> {
    return this.subscribeOn(Schedulers.newThread())
}

fun <T> Maybe<T>.subscribeOnComputation(): Maybe<T> {
    return this.subscribeOn(Schedulers.computation())
}

fun <T> Single<T>.observeOnMainThread(): Single<T> {
    return this.observeOn(AndroidSchedulers.mainThread())
}

fun <T> Single<T>.subscribeOnIO(): Single<T> {
    return this.subscribeOn(Schedulers.io())
}

fun <T> Single<T>.subscribeOnNewThread(): Single<T> {
    return this.subscribeOn(Schedulers.newThread())
}

fun <T> Single<T>.subscribeOnComputation(): Single<T> {
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

operator fun CompositeDisposable.plus(disposable: Disposable): CompositeDisposable {
    this.add(disposable)
    return this
}
