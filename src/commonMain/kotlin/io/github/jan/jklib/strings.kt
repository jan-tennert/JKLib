@file:JvmName("StringUtil")
package io.github.jan.jklib

import kotlin.jvm.JvmName

fun String.invertBinaryString() = map { if (it == '0') '1' else '0' }.joinToString("")
