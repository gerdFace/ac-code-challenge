package com.example.accodechallenge.util

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager

val <T> T.exhaustive: T
    get() = this

fun Activity?.tryHideKeyboardIfVisible() {
    try {
        val inputMethodManager = this?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val currentFocusedView = currentFocus
        currentFocusedView?.let {
            inputMethodManager.hideSoftInputFromWindow(currentFocusedView.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    } catch (e: Throwable) {
        // not much we can do here
    }
}