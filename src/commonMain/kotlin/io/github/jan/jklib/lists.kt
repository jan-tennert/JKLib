@file:JvmName("ListUtil")
package io.github.jan.jklib

import kotlin.jvm.JvmName

inline fun <T>Iterable<T>.splitAt(index: Int): Pair<List<T>, List<T>> = this.toList().subList(0, index) to this.toList().subList(index, this.toList().size)

inline fun CharSequence.splitAt(index: Int): Pair<String, String> = this.substring(0, index) to this.substring(index, this.length)

inline fun <T>Array<T>.splitAt(index: Int): Pair<Array<T>, Array<T>> = this.copyOfRange(0, index) to this.copyOfRange(index, this.size)

