package com.vurtnewk.core.ext

import android.content.res.Resources
import android.util.TypedValue

/**
 * createTime:  2024/12/31 16:31
 * author:      vurtnewk
 * description:
 */


fun Int.spToPx(): Float {
    return this.toFloat().spToPx()
}

fun Float.spToPx(): Float {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, this, Resources.getSystem().displayMetrics)
}

fun Int.dpToPx(): Float {
    return this.toFloat().dpToPx()
}

fun Float.dpToPx(): Float {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, Resources.getSystem().displayMetrics)
}

