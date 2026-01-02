package com.ext.htmltextview

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.text.Html
import android.text.SpannableStringBuilder
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.URLSpan
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatTextView

class HtmlTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    private var linkClickListener: OnLinkClickListener? = null

    init {
        movementMethod = object : LinkMovementMethod() {
            fun onLinkClick(widget: android.widget.TextView, url: String): Boolean {
                return linkClickListener?.onLinkClick(url) ?: false
            }
        }


        attrs?.let {
            val typedArray = context.obtainStyledAttributes(
                it,
                R.styleable.HtmlTextView
            )
            val html = typedArray.getString(
                R.styleable.HtmlTextView_htmlText
            )
            val linkColor = typedArray.getColor(
                R.styleable.HtmlTextView_linkColor,
                currentTextColor
            )

            val lineSpacing = typedArray.getDimension(
                R.styleable.HtmlTextView_lineSpacingExtra,
                0f
            )

            setLinkTextColor(linkColor)
            setLineSpacing(lineSpacing, 1f)

            typedArray.recycle()

            html?.let { setHtml(it) }
        }
    }

    fun setHtml(html: String) {

        // 1️⃣ Parse HTML WITH image support
        val spanned = Html.fromHtml(
            html,
            Html.FROM_HTML_MODE_LEGACY,
            HtmlImageGetter(this),   // ⭐ THIS WAS MISSING
            null
        )

        val spannable = SpannableStringBuilder(spanned)

        // 2️⃣ Intercept <a href="">
        val urlSpans = spannable.getSpans(
            0,
            spannable.length,
            URLSpan::class.java
        )

        for (span in urlSpans) {
            val start = spannable.getSpanStart(span)
            val end = spannable.getSpanEnd(span)
            val flags = spannable.getSpanFlags(span)
            val url = span.url

            spannable.removeSpan(span)

            spannable.setSpan(
                object : ClickableSpan() {
                    override fun onClick(widget: View) {
                        val handledByUser =
                            linkClickListener?.onLinkClick(url) == true

                        if (!handledByUser) {
                            widget.context.startActivity(
                                Intent(
                                    Intent.ACTION_VIEW,
                                    Uri.parse(url)
                                )
                            )
                        }
                    }
                },
                start,
                end,
                flags
            )
        }

        // 3️⃣ Apply text
        text = spannable
        movementMethod = LinkMovementMethod.getInstance()
    }


    fun setOnLinkClickListener(listener: OnLinkClickListener) {
        linkClickListener = listener
    }
}
