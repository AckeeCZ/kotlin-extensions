package cz.ackee.extensions.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity

// Extensions for Architecture Components ViewModels

inline fun <reified T : ViewModel> Fragment.getViewModel(factory: ViewModelProvider.Factory) = ViewModelProviders.of(this, factory).get(T::class.java)

inline fun <reified T : ViewModel> FragmentActivity.getViewModel(factory: ViewModelProvider.Factory) = ViewModelProviders.of(this, factory).get(T::class.java)