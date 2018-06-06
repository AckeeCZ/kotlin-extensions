package cz.ackee.extensions.epoxy

import com.airbnb.epoxy.EpoxyController
import kotlin.properties.ObservableProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

// Extensions for EpoxyController

/**
 * Returns a property delegate for a read/write property that calls [EpoxyController#requestModelBuild] method when property is changed
 * @param initialValue the initial value of the property.
 */
fun <T> EpoxyController.adapterProperty(initialValue: T): ReadWriteProperty<Any?, T> = object : ObservableProperty<T>(initialValue) {
    override fun afterChange(property: KProperty<*>, oldValue: T, newValue: T) {
        requestModelBuild()
    }
}