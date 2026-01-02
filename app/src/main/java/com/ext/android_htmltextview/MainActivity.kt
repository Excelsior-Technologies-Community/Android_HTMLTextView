package com.ext.android_htmltextview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ext.htmltextview.HtmlTextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val htmlView = findViewById<HtmlTextView>(R.id.htmlView)
        htmlView.setHtml(
            """
    <h2>Hello</h2>
    <p>This is <b>HTML</b> text</p>
    <img src="https://via.placeholder.com/300" />
    <p>Image above</p>
    <a href="https://google.com">Google</a>
    """.trimIndent()
        )

    }
}