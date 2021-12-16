package io.github.jan.jklib

import kotlin.jvm.JvmOverloads

class Loop @PublishedApi internal constructor(
    private val body: Loop.() -> Unit = {},
    private val condition: () -> Boolean = { true },
    private val maxRuns: UInt = 0u,
    private val suspendingBody: suspend Loop.() -> Unit = {}
) {

    /**
     * Stops this loop
     */
    val stop: Nothing
        get() = throw LoopExit

    /**
     * Skips the current iteration of this loop
     */
    val skip: Nothing
        get() = throw LoopSkip

    /**
     * Specifies how many times this loop ran
     */
    var runs: UInt = 0u
        private set

    fun start(): Unit = try {
        while(condition()) {
            runs++
            body()
        }
    } catch (_: LoopExit) {} catch (_: LoopSkip) { start() }

    suspend fun startSuspending(): Unit = try {
        while(condition() && (runs < maxRuns || maxRuns == 0u)) {
            runs++
            suspendingBody()
        }
    } catch (_: LoopExit) {} catch (_: LoopSkip) { startSuspending() }

    private object LoopExit : Exception()
    private object LoopSkip : Exception()

}


inline fun loop(maxRuns: UInt = 0u, noinline condition: () -> Boolean = {true }, noinline body: Loop.() -> Unit) = Loop(body, condition = condition, maxRuns = maxRuns).start()
suspend inline fun suspendingLoop(maxRuns: UInt = 0u, noinline condition: () -> Boolean = {true}, noinline body: suspend Loop.() -> Unit) = Loop(condition = condition, maxRuns = maxRuns, suspendingBody = body).startSuspending()

