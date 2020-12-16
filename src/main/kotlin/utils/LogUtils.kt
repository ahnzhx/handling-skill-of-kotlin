package utils

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class LoggerDelegate<in R : Any> : ReadOnlyProperty<R, Logger> {
    override fun getValue(thisRef: R, property: KProperty<*>) =
        getLogger(
            getClassForLogging(thisRef.javaClass)
        )
}

// TODO 수정 필요
fun <T : Any> getClassForLogging(javaClass: Class<T>): Class<*> {
    return javaClass.enclosingClass?.takeIf {
        it.kotlin.companion?.java == javaClass
    } ?: javaClass
}

fun getLogger(forClass: Class<*>): Logger = LoggerFactory.getLogger(forClass)