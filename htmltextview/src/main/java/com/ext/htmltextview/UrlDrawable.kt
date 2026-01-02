package com.ext.htmltextview

import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable

class UrlDrawable : BitmapDrawable() {

    private var drawable: Drawable? = null

    fun setDrawable(drawable: Drawable) {
        this.drawable = drawable
    }

    override fun draw(canvas: Canvas) {
        drawable?.draw(canvas)
    }
}
