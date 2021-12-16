package io.github.jan.jklib

import kotlin.js.JsName
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads
import kotlin.reflect.KFunction
import kotlin.reflect.KProperty1
import kotlin.reflect.KFunction1

inline infix fun <T, V> KProperty1<T, V>.equals(other: Any?) = { receiver: T -> this(receiver) == other }
inline infix fun <T, V> KProperty1<T, V>.notEquals(other: Any?) = { receiver: T -> this(receiver) != other }
inline infix fun <T, V> KFunction1<T, V>.equals(other: Any?) = { receiver: T -> this(receiver) == other }
inline infix fun <T, V> KFunction1<T, V>.notEquals(other: Any?) = { receiver: T -> this(receiver) != other }

inline infix fun <T, V : Comparable<V>> KProperty1<T, V>.higherThan(other: V) = { receiver: T -> this(receiver) > other }
inline infix fun <T, V : Comparable<V>> KProperty1<T, V>.lowerThan(other: V) = { receiver: T -> this(receiver) < other }

inline infix fun <T, V : Comparable<V>> KFunction1<T, V>.higherThan(other: V) = { receiver: T -> this(receiver) > other }
inline infix fun <T, V : Comparable<V>> KFunction1<T, V>.lowerThan(other: V) = { receiver: T -> this(receiver) < other }
