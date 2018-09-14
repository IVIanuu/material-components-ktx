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

package com.google.android.material.textfield


import android.content.res.ColorStateList
import com.google.android.material.internal.NO_GETTER
import com.google.android.material.internal.colorAttr
import com.google.android.material.internal.noGetter

var TextInputLayout.focusedHintTextColor: Int
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    set(value) {
        defaultHintTextColor = ColorStateList(
            arrayOf(
                intArrayOf(android.R.attr.state_focused),
                intArrayOf()
            ),
            intArrayOf(value, context.colorAttr(android.R.attr.textColorSecondary))
        )
    }