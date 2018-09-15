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

package com.ivianuu.materialcomponentsktx.sample

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.ivianuu.materialcomponentsktx.bottomnavigation.itemRippleColorResource
import com.ivianuu.materialcomponentsktx.bottomnavigation.setItemColors
import com.ivianuu.materialcomponentsktx.tabs.iconResource
import com.ivianuu.materialcomponentsktx.tabs.selectedTabIndicatorColorResource
import com.ivianuu.materialcomponentsktx.tabs.setTabColors
import com.ivianuu.materialcomponentsktx.tabs.tabRippleColorIntResource
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNav()
        tabLayout()
    }

    private fun bottomNav() {
        bottom_navigation_view.apply {
            inflateMenu(R.menu.bottom_nav)
            setBackgroundColor(Color.WHITE)
            itemRippleColorResource = R.color.colorAccent
            setItemColors(
                color(R.color.secondary_text_default_material_light),
                color(R.color.colorAccent)
            )
        }
    }

    private fun tabLayout() {
        tab_layout.apply {
            setBackgroundColor(Color.WHITE)
            tabRippleColorIntResource = R.color.colorAccent
            selectedTabIndicatorColorResource = R.color.colorAccent
            setTabColors(
                color(R.color.secondary_text_default_material_light),
                color(R.color.colorAccent)
            )
        }

        (1..5).forEach { i ->
            tab_layout.newTab().apply {
                text = "Tab $i"
                iconResource = R.drawable.abc_ic_ab_back_material
                tab_layout.addTab(this)
            }
        }
    }

    private fun color(res: Int) = ContextCompat.getColor(this, res)
}
