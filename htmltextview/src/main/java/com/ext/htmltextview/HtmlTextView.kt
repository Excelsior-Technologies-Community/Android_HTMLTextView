package com.ext.htmltextview

import android.content.Context
import android.text.Html
import android.text.method.LinkMovementMethod
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class HtmlTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    init {
        movementMethod = LinkMovementMethod.getInstance()

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(
                it,
                R.styleable.HtmlTextView
            )
            val html = typedArray.getString(
                R.styleable.HtmlTextView_htmlText
            )
            typedArray.recycle()

            html?.let { setHtml(it) }
        }
    }

    fun setHtml(html: String) {
        text = Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY)
    }
}
