package com.google.android.material

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.snackbar.actionTextColor
import com.google.android.material.snackbar.backgroundColor
import com.google.android.material.snackbar.doOnDismissed
import com.google.android.material.snackbar.doOnShown
import com.google.android.material.snackbar.snackbar
import com.google.android.material.snackbar.textColor

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val content = findViewById<ViewGroup>(android.R.id.content)

        content.snackbar("Hello") {
            backgroundColor = Color.BLUE
            actionTextColor = Color.RED
            textColor = Color.GREEN

            doOnShown { Log.d("Snackbar", "shown") }
            doOnDismissed { _, _ -> Log.d("Snackbar", "dismissed") }
            setAction("Click me") { Log.d("Snackbar", "clicked") }
        }
    }
}
