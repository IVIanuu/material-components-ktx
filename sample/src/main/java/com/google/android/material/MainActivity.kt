package com.google.android.material

import android.graphics.Color
import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.tablayout.iconResource
import com.google.android.material.tablayout.selectedTabIndicatorColorResource
import com.google.android.material.tablayout.setTabContentColors
import com.google.android.material.tablayout.tabRippleColorIntResource
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun color(res: Int) = ContextCompat.getColor(this, res)

    private fun tabLayout() {
        tab_layout.apply {
            setBackgroundColor(Color.WHITE)
            tabRippleColorIntResource = R.color.colorAccent
            selectedTabIndicatorColorResource = R.color.colorAccent
            setTabContentColors(
                color(R.color.secondary_text_default_material_light),
                color(R.color.colorAccent)
            )
        }

        (0..5)
            .map { tab_layout.newTab() }
            .forEach {
                it.text = "Hehe"
                it.iconResource = R.drawable.abc_ic_ab_back_material
                tab_layout.addTab(it)
            }
    }

    private fun snackbar() {

        val content = findViewById<ViewGroup>(android.R.id.content)

        /**content.snackbar("Hello") {
        backgroundColor = Color.BLUE
        actionTextColor = Color.RED
        textColor = Color.GREEN

        doOnShown { Log.d("Snackbar", "shown") }
        doOnDismissed { _, _ -> Log.d("Snackbar", "dismissed") }
        setAction("Click me") { Log.d("Snackbar", "clicked") }
        }*/
    }
}
