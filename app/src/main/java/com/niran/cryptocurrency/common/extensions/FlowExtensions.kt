package com.niran.cryptocurrency.common.extensions

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.flow.*

@JvmOverloads
fun <T> Flow<T>.launchOnce(
    scope: CoroutineScope,
    onCompletion: ((Throwable?) -> Unit)? = null,
    action: (T) -> Unit,
) = onEach { action(it) }.onCompletion { cause ->
    onCompletion?.let { it(cause) }
    currentCoroutineContext().cancel()
}.launchIn(scope)
