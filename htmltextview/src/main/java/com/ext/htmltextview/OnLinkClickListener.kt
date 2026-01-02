package com.ext.htmltextview

interface OnLinkClickListener {
    /**
     * @return true if you handled the click yourself,
     * false to allow default behavior
     */
    fun onLinkClick(url: String): Boolean
}
