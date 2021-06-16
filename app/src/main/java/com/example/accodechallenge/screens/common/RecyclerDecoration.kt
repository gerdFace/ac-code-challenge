package com.example.accodechallenge.screens.common

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.recyclerview.widget.DividerItemDecoration

class RecyclerDecoration @JvmOverloads constructor(
    context: Context,
    orientation: Int,
    decorationDrawable: Drawable? = null
) : DividerItemDecoration(context, orientation) {

    init {
        if (decorationDrawable != null) {
            super.setDrawable(decorationDrawable)
        }
    }
}