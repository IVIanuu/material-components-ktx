package com.google.android.material

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.bottomnavigation.itemRippleColorResource
import com.google.android.material.bottomnavigation.setItemColors
import com.google.android.material.tabs.iconResource
import com.google.android.material.tabs.selectedTabIndicatorColorResource
import com.google.android.material.tabs.setTabColors
import com.google.android.material.tabs.tabRippleColorIntResource
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
