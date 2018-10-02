/*
 * Copyright 2018 Manuel Wrage
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ivianuu.materialcomponentsktx.snackbar

import android.view.View
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

fun Snackbar.doOnShown(block: (transientBottomBar: Snackbar) -> Unit) =
    addCallback(onShown = block)

fun Snackbar.doOnDismissed(block: (transientBottomBar: Snackbar, event: Int) -> Unit) =
    addCallback(onDismissed = block)

fun Snackbar.addCallback(
    onShown: ((transientBottomBar: Snackbar) -> Unit)? = null,
    onDismissed: ((transientBottomBar: Snackbar, event: Int) -> Unit)? = null
): BaseTransientBottomBar.BaseCallback<Snackbar> {
    val callback = object : BaseTransientBottomBar.BaseCallback<Snackbar>() {
        override fun onShown(transientBottomBar: Snackbar) {
            onShown?.invoke(transientBottomBar)
        }

        override fun onDismissed(transientBottomBar: Snackbar, event: Int) {
            onDismissed?.invoke(transientBottomBar, event)
        }
    }
    addCallback(callback)
    return callback
}

private val snackbarInitStub: Snackbar.() -> Unit = {}

fun View.snackbar(
    textRes: Int,
    length: Int = Snackbar.LENGTH_LONG,
    block: Snackbar.() -> Unit = snackbarInitStub
) =
    Snackbar.make(this, textRes, length).apply(block).apply { show() }

fun View.snackbar(
    text: CharSequence,
    length: Int = Snackbar.LENGTH_LONG,
    block: Snackbar.() -> Unit = snackbarInitStub
) =
    Snackbar.make(this, text, length).apply(block).apply { show() }