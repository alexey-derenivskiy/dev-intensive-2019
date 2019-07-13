package ru.skillbranch.devintensive.extensions

import android.app.Activity
import android.content.Context
import android.graphics.Rect
import android.view.inputmethod.InputMethodManager

fun Activity.hideKeyboard() {
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(currentFocus?.windowToken, InputMethodManager.SHOW_FORCED)
}

//TODO - **
/*
fun Activity.isisKeyboardOpen(){
    rootView.getWindowVisibleDisplayFrame(Rect())
}
*/

//TODO - **
/*
fun Activity.isisKeyboardClosed(){
    rootView.getWindowVisibleDisplayFrame(Rect())
}
*/