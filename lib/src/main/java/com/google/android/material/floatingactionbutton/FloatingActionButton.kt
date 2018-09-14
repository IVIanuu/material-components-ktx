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

package com.google.android.material.floatingactionbutton

import android.content.res.ColorStateList
import androidx.core.content.ContextCompat
import com.google.android.material.internal.NO_GETTER
import com.google.android.material.internal.noGetter

var FloatingActionButton.backgroundColor: Int
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    set(value) { backgroundTintList = ColorStateList.valueOf(value) }

var FloatingActionButton.backgroundColorResource: Int
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    set(value) { backgroundColor = ContextCompat.getColor(context, value) }

var FloatingActionButton.rippleColorResource: Int
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    set(value) { rippleColor = ContextCompat.getColor(context, value) }

var FloatingActionButton.shouldShow: Boolean
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    set(value) {
        if (value) {
            show()
        } else {
            hide()
        }
    }

var FloatingActionButton.shouldHide: Boolean
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    set(value) {
        if (value) {
            hide()
        } else {
            show()
        }
    }