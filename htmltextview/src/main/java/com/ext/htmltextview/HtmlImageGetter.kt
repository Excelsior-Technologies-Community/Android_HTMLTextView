package com.ext.htmltextview

import android.graphics.drawable.Drawable
import android.text.Html
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition

class HtmlImageGetter(
    private val textView: TextView
) : Html.ImageGetter {

    override fun getDrawable(source: String?): Drawable {
        val drawable = UrlDrawable()

        Glide.with(textView.context)
            .load(source)
            .into(object : CustomTarget<Drawable>() {
                override fun onResourceReady(
                    resource: Drawable,
                    transition: Transition<in Drawable>?
                ) {
                    resource.setBounds(
                        0, 0,
                        resource.intrinsicWidth,
                        resource.intrinsicHeight
                    )
                    drawable.setDrawable(resource)
                    textView.text = textView.text // refresh
                }

                override fun onLoadCleared(placeholder: Drawable?) {}
            })

        return drawable
    }
}
