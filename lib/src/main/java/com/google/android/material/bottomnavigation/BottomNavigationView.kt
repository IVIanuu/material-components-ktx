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

package com.google.android.material.bottomnavigation

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.graphics.drawable.RippleDrawable
import android.os.Build
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.view.ViewCompat
import com.google.android.material.internal.NO_GETTER
import com.google.android.material.internal.noGetter
import com.google.android.material.ripple.RippleUtils

var BottomNavigationView.itemIconSizeResource: Int
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    set(value) {
        setItemIconSizeRes(value)
    }

var BottomNavigationView.itemIconTintListResource: Int
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    @Suppress("DEPRECATION")
    set(value) {
        itemIconTintList = resources.getColorStateList(value)
    }

var BottomNavigationView.itemRippleColor: Int
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    @SuppressLint("RestrictedApi")
    set(value) {
        val rippleColor = RippleUtils.convertToRippleDrawableColor(ColorStateList.valueOf(value))

        val maskDrawable = GradientDrawable().apply {
            cornerRadius = 0.00001F
            setColor(Color.WHITE)
        }

        val background = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            RippleDrawable(
                rippleColor,
                null,
                maskDrawable
            )
        } else {
            val contentDrawable = GradientDrawable()
            contentDrawable.setColor(Color.TRANSPARENT)

            val rippleDrawable = DrawableCompat.wrap(maskDrawable)
            DrawableCompat.setTintList(rippleDrawable, rippleColor)
            LayerDrawable(arrayOf(contentDrawable, rippleDrawable))
        }

        ViewCompat.setBackground(this, background)
    }

var BottomNavigationView.itemRippleColorResource: Int
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    @SuppressLint("RestrictedApi")
    set(value) {
        itemRippleColor = ContextCompat.getColor(context, value)
    }

var BottomNavigationView.itemTextColorResource: Int
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    @Suppress("DEPRECATION")
    set(value) {
        itemTextColor = resources.getColorStateList(value)
    }

fun BottomNavigationView.setItemTextColors(normalColor: Int, selectedColor: Int) {
    itemTextColor = ColorStateList(
        arrayOf(
            intArrayOf(-android.R.attr.state_selected),
            intArrayOf(android.R.attr.state_selected)
        ),
        intArrayOf(normalColor, selectedColor)
    )
}

fun BottomNavigationView.setItemIconColors(normalColor: Int, selectedColor: Int) {
    itemIconTintList = ColorStateList(
        arrayOf(
            intArrayOf(-android.R.attr.state_selected),
            intArrayOf(android.R.attr.state_selected)
        ),
        intArrayOf(normalColor, selectedColor)
    )
}

fun BottomNavigationView.setItemColors(normalColor: Int, selectedColor: Int) {
    setItemIconColors(normalColor, selectedColor)
    setItemTextColors(normalColor, selectedColor)
}

/**
fun BottomNavigationView.tint(color: Int) {
setBackgroundColor(color)

val activeColor = prima

itemTextColor = ColorStateList(
arrayOf(
intArrayOf(android.R.attr.state_selected),
intArrayOf()
),
intArrayOf(activeColor, inactiveColor)
)


setItemRippleColor(color)
}

fun BottomNavigationView.setItemRippleColor(color: Int) {
try {
val menuViewField = BottomNavigationView::class.field("menuView")
val menuView = menuViewField.get(this)
val buttonsField = menuView::class.field("buttons")
val buttons = buttonsField.get(menuView) as Array<BottomNavigationItemView>
buttons.forEach {
it.background.setTintList(
RippleUtils.convertToRippleDrawableColor(ColorStateList.valueOf(color))
)
}
} catch (e: Exception) {
e.printStackTrace()
}
}
 */